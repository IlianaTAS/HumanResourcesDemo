/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.recursoshumanoscenicco.controller;

import com.lam.recursoshumanoscenicco.exception.ServiceException;
import com.lam.recursoshumanoscenicco.model.CatalogoParametro;
import com.lam.recursoshumanoscenicco.model.Examen;
import com.lam.recursoshumanoscenicco.model.Pregunta;
import com.lam.recursoshumanoscenicco.model.Puesto;
import com.lam.recursoshumanoscenicco.model.Respuesta;
import com.lam.recursoshumanoscenicco.service.CatalogoParametroService;
import com.lam.recursoshumanoscenicco.service.ExamenService;
import com.lam.recursoshumanoscenicco.service.PuestoService;
import com.lam.recursoshumanoscenicco.to.ConfiguracionPregunta;
import com.lam.recursoshumanoscenicco.utils.Constantes;
import com.lam.recursoshumanoscenicco.utils.Mensajes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.FlowEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author iperez
 */
public class ExamenTecnicoController implements Serializable {

    private final static Logger logger = LoggerFactory.getLogger(ExamenTecnicoController.class);

    private ExamenService examenService;
    private PuestoService puestoService;
    private CatalogoParametroService catalogoParametroService;

    private List<Puesto> listaPuestos;
    private List<ConfiguracionPregunta> preguntasAbiertas;
    private List<ConfiguracionPregunta> preguntasCerradas;
    private List<ConfiguracionPregunta> preguntasMultiples;
    private Examen examen;

    @PostConstruct
    public void init() {
        this.listaPuestos = new ArrayList<>();
        this.preguntasAbiertas = new ArrayList<>();
        this.preguntasCerradas = new ArrayList<>();
        this.preguntasMultiples = new ArrayList<>();

        this.examen = new Examen();

        this.consultarEntidades();
    }

    /**
     * Método que se expone al front para la creación de exámenes.
     *
     * @param event
     */
    public void crearExamen(ActionEvent event) {
        System.out.println("DEBUG IIPG --> Estoy en el guardado:::::::");
        try {
            this.examen.setCatalogoParametro(this.catalogoParametroService.findParametroBy(Constantes.CATALOGO_PARAMETRO_EXAMEN_TECNICO));
            this.examen.setPreguntas(this.crearObjetoPreguntas());
            this.examenService.guardar(this.examen);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

    }

    public String wizardExamen(FlowEvent event) {
        System.out.println("DEBUG IIPG --> Entre al listener del wizard....." + event.getNewStep() + "|" + event.getOldStep());
        if (event.getNewStep().equals("pregunta")) {
            if (examen.getPeguntasAbiertas() != preguntasAbiertas.size()) {
                for (int i = 0; i < examen.getPeguntasAbiertas(); i++) {
                    ConfiguracionPregunta preguntaA = new ConfiguracionPregunta();
                    preguntaA.setNumero(String.valueOf(i + 1));
                    this.preguntasAbiertas.add(preguntaA);
                }
            }

            if (examen.getPreguntasCerradas() != preguntasCerradas.size()) {
                for (int i = 0; i < examen.getPreguntasCerradas(); i++) {
                    ConfiguracionPregunta preguntaC = new ConfiguracionPregunta();
                    preguntaC.setNumero(String.valueOf(i + 1));
                    this.preguntasCerradas.add(preguntaC);
                }
            }

            if (examen.getPreguntasMultiples() != preguntasMultiples.size()) {
                for (int i = 0; i < examen.getPreguntasMultiples(); i++) {
                    ConfiguracionPregunta preguntaM = new ConfiguracionPregunta();
                    preguntaM.setNumero(String.valueOf(i + 1));
                    this.preguntasMultiples.add(preguntaM);
                }
            }
        }
        return event.getNewStep();
    }

    /**
     * Método para devolver el mensaje a la vista para el usuario.
     *
     * @param summary Detalle que se muestra en el mensaje.
     * @param isValidate Parametro para determinar si la operación se realizo
     * con exito o error.
     */
    public void addMessage(String summary, boolean isValidate) {
        FacesMessage message = new FacesMessage();
        if (isValidate) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, null);
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    private void consultarEntidades() {
        try {
            this.listaPuestos = this.puestoService.buscarTodo();
        } catch (ServiceException e) {
            logger.error("Error en el servicio [puestoService.buscarTodo]", e);
            this.addMessage(Mensajes.ERROR_CONSULTAR_PUESTO, false);
        }
    }

    private List<Pregunta> crearObjetoPreguntas() {
        System.out.println("DEBUG IIPG --> Voy a armar las preguntas:::::::");
        try {
            List<Pregunta> preguntasExamen = new ArrayList<>();
            CatalogoParametro preguntaAbierta = this.catalogoParametroService.findParametroBy(Constantes.CATALOGO_PARAMETRO_PREGUNTA_ABIERTA);
            CatalogoParametro preguntaCerrada = this.catalogoParametroService.findParametroBy(Constantes.CATALOGO_PARAMETRO_PREGUNTA_CERRADA);
            CatalogoParametro preguntaMultiple = this.catalogoParametroService.findParametroBy(Constantes.CATALOGO_PARAMETRO_PREGUNTA_MULTIPLE);

            this.preguntasAbiertas.stream().map((configPregunta) -> {
                Pregunta pregunta = new Pregunta();
                pregunta.setCatalogoParametro(preguntaAbierta);
                pregunta.setDescripcion(configPregunta.getPregunta());
                return pregunta;
            }).forEachOrdered((pregunta) -> {
                preguntasExamen.add(pregunta);
            });

            this.preguntasCerradas.stream().map((configPregunta) -> {
                Pregunta pregunta = new Pregunta();
                pregunta.setCatalogoParametro(preguntaCerrada);
                pregunta.setDescripcion(configPregunta.getPregunta());
                return pregunta;
            }).forEachOrdered((pregunta) -> {
                preguntasExamen.add(pregunta);
            });

            this.preguntasAbiertas.stream().map((configPregunta) -> {
                Pregunta pregunta = new Pregunta();
                pregunta.setCatalogoParametro(preguntaMultiple);
                pregunta.setDescripcion(configPregunta.getPregunta());
                pregunta.setRespuestas(this.crearObjetoRespuesta(configPregunta ,pregunta));
                return pregunta;
            }).forEachOrdered((pregunta) -> {
                preguntasExamen.add(pregunta);
            });

            return preguntasExamen;
        } catch (ServiceException e) {
            logger.error("Error en el servicio [catalogoParametroService.buscarPorValor]", e);
            this.addMessage(Mensajes.ERROR_CONSULTAR_PARAMETRO, false);
            return null;
        }
    }
    
    private List<Respuesta> crearObjetoRespuesta(ConfiguracionPregunta configPregunta, Pregunta pregunta) {
        System.out.println("DEBUG IIPG --> Entro a crear respuestas de la pregunta: " + pregunta.getDescripcion());
        List<Respuesta> respuestas = new ArrayList<>();
        Respuesta respuestaUno = new Respuesta();
        Respuesta respuestaDos = new Respuesta();
        Respuesta respuestaTres = new Respuesta();
        //
        respuestaUno.setDescripcion(configPregunta.getRespuestaC());
        respuestaUno.setEstado(Constantes.EXAMEN_RESPUESTA_CORRECTA);
        respuestaUno.setPregunta(pregunta);
        respuestas.add(respuestaUno);
        
        respuestaDos.setDescripcion(configPregunta.getRespuestaE1());
        respuestaDos.setEstado(Constantes.EXAMEN_RESPUESTA_INCORRECTA);
        respuestaDos.setPregunta(pregunta);
        respuestas.add(respuestaDos);
        
        respuestaTres.setDescripcion(configPregunta.getRespuestaE2());
        respuestaTres.setEstado(Constantes.EXAMEN_RESPUESTA_INCORRECTA);
        respuestaTres.setPregunta(pregunta);
        respuestas.add(respuestaTres);
        return respuestas;
    }

    public List<Puesto> getListaPuestos() {
        return listaPuestos;
    }

    public ExamenService getExamenService() {
        return examenService;
    }

    public void setExamenService(ExamenService examenService) {
        this.examenService = examenService;
    }

    public PuestoService getPuestoService() {
        return puestoService;
    }

    public void setPuestoService(PuestoService puestoService) {
        this.puestoService = puestoService;
    }

    public CatalogoParametroService getCatalogoParametroService() {
        return catalogoParametroService;
    }

    public void setCatalogoParametroService(CatalogoParametroService catalogoParametroService) {
        this.catalogoParametroService = catalogoParametroService;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public List<ConfiguracionPregunta> getPreguntasAbiertas() {
        return preguntasAbiertas;
    }

    public void setPreguntasAbiertas(List<ConfiguracionPregunta> preguntasAbiertas) {
        this.preguntasAbiertas = preguntasAbiertas;
    }

    public List<ConfiguracionPregunta> getPreguntasCerradas() {
        return preguntasCerradas;
    }

    public void setPreguntasCerradas(List<ConfiguracionPregunta> preguntasCerradas) {
        this.preguntasCerradas = preguntasCerradas;
    }

    public List<ConfiguracionPregunta> getPreguntasMultiples() {
        return preguntasMultiples;
    }

    public void setPreguntasMultiples(List<ConfiguracionPregunta> preguntasMultiples) {
        this.preguntasMultiples = preguntasMultiples;
    }

}
