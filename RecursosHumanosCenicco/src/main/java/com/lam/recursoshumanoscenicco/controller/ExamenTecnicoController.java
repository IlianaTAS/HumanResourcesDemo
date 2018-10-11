/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.recursoshumanoscenicco.controller;

import com.lam.recursoshumanoscenicco.dto.ExamenDTO;
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
import com.lam.recursoshumanoscenicco.utils.Util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

    private Map<String, CatalogoParametro> mapParametrosPreguntas;
    private Map<String, CatalogoParametro> mapParametrosExamenes;
    private List<Puesto> listaPuestos;
    private List<ConfiguracionPregunta> preguntasAbiertas;
    private List<ConfiguracionPregunta> preguntasCerradas;
    private List<ConfiguracionPregunta> preguntasMultiples;
    private Examen examen;
    private ExamenDTO examenDTO;
    private Puesto puestoE;

    @PostConstruct
    public void init() {
        this.mapParametrosPreguntas = new HashMap<>();
        this.mapParametrosExamenes = new HashMap<>();
        this.listaPuestos = new ArrayList<>();
        this.preguntasAbiertas = new ArrayList<>();
        this.preguntasCerradas = new ArrayList<>();
        this.preguntasMultiples = new ArrayList<>();

        this.examen = new Examen();
        this.examenDTO = new ExamenDTO();
        this.puestoE = new Puesto();

        this.consultarEntidades();
    }

    /**
     * Método que se expone al front para la creación de exámenes.
     *
     * @param event
     */
    public void crearExamen(ActionEvent event) {
        try {
            this.examen.setPuesto(puestoE);
            this.examen.setCatalogoParametro(mapParametrosExamenes.get(Constantes.CATALOGO_PARAMETRO_EXAMEN_TECNICO));
            this.examen.setPreguntas(this.crearObjetoPreguntas());
            this.examenService.guardar(this.examen);
            logger.info("El examen que se va a crear: " + Util.debugImprimirContenidoObjecto(this.examen));
        } catch (ServiceException e) {
            logger.error("Error en el servicio [examenService.guardar]", e);
            this.addMessage(Mensajes.ERROR_CREAR_EXAMEN, false);
        }
    }

    /**
     * Método que da funcionalidad a las diferentes pestañas cuando se configura
     * el examen.
     *
     * @param event Parámetro de los eventos para las vistas.
     * @return el nombre de la pestaña en la que se encuentra el usuario que
     * configura el examen.
     */
    public String wizardExamen(FlowEvent event) {
        try {
            this.puestoE = this.puestoService.buscarPorId(this.examen.getPuesto().getIdPuesto());
        } catch (ServiceException e) {
            logger.error("Error en el servicio [ServiceException.buscarPorId]", e);
            this.addMessage(Mensajes.ERROR_CONSULTAR_PUESTO, false);
        }
        if (event.getNewStep().equals("pregunta")) {
            if (examenDTO.getPeguntasAbiertas() != preguntasAbiertas.size()) {
                for (int i = 0; i < examenDTO.getPeguntasAbiertas(); i++) {
                    ConfiguracionPregunta preguntaA = new ConfiguracionPregunta();
                    preguntaA.setNumero(String.valueOf(i + 1));
                    this.preguntasAbiertas.add(preguntaA);
                }
            }

            if (examenDTO.getPreguntasCerradas() != preguntasCerradas.size()) {
                for (int i = 0; i < examenDTO.getPreguntasCerradas(); i++) {
                    ConfiguracionPregunta preguntaC = new ConfiguracionPregunta();
                    preguntaC.setNumero(String.valueOf(i + 1));
                    this.preguntasCerradas.add(preguntaC);
                }
            }

            if (examenDTO.getPreguntasMultiples() != preguntasMultiples.size()) {
                for (int i = 0; i < examenDTO.getPreguntasMultiples(); i++) {
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

    /**
     * Método privado que consulta las entidades que la pantalla requiere al
     * inicio de la carga.
     */
    private void consultarEntidades() {
        try {
            this.listaPuestos = this.puestoService.buscarTodo();
            this.mapParametrosPreguntas = this.catalogoParametroService.findParametroBy(Constantes.CATALOGO_PARAMETRO_TIPOPREGUNTA);
            this.mapParametrosExamenes = this.catalogoParametroService.findParametroBy(Constantes.CATALOGO_PARAMETRO_TIPOEXAMEN);
        } catch (ServiceException e) {
            logger.error("Error en el servicio [puestoService.buscarTodo]", e);
            this.addMessage(Mensajes.ERROR_CONSULTAR_PUESTO, false);
        }
    }

    /**
     * Método privado que crea la relación entre el examen y las preguntas que
     * el usuario configura para la creación del objeto.
     *
     * @return la lista de preguntas armadas que se asignan al examen.
     */
    private Set<Pregunta> crearObjetoPreguntas() {
        Set<Pregunta> preguntasExamen = new HashSet<>();
        
        logger.info("Las preguntas abiertas del examen: " + Util.debugImprimirContenidoListaObjeto(this.preguntasAbiertas));
        logger.info("Las preguntas cerradas del examen: " + Util.debugImprimirContenidoListaObjeto(this.preguntasCerradas));
        logger.info("Las preguntas múltiples del examen: " + Util.debugImprimirContenidoListaObjeto(this.preguntasMultiples));

        this.preguntasAbiertas.stream().map((configPregunta) -> {
            Pregunta preguntaA = new Pregunta();
            preguntaA.setCatalogoParametro(mapParametrosPreguntas.get(Constantes.CATALOGO_PARAMETRO_PREGUNTA_ABIERTA));
            preguntaA.setDescripcion(configPregunta.getPregunta());
            preguntaA.setRespuestas(null);
            return preguntaA;
        }).forEachOrdered((preguntaA) -> {
            preguntasExamen.add(preguntaA);
        });

        this.preguntasCerradas.stream().map((configPregunta) -> {
            Pregunta preguntaC = new Pregunta();
            preguntaC.setCatalogoParametro(mapParametrosPreguntas.get(Constantes.CATALOGO_PARAMETRO_PREGUNTA_CERRADA));
            preguntaC.setDescripcion(configPregunta.getPregunta());
            preguntaC.setRespuestas(null);
            return preguntaC;
        }).forEachOrdered((preguntaC) -> {
            preguntasExamen.add(preguntaC);
        });

        this.preguntasMultiples.stream().map((configPregunta) -> {
            Pregunta preguntaM = new Pregunta();
            preguntaM.setCatalogoParametro(mapParametrosPreguntas.get(Constantes.CATALOGO_PARAMETRO_PREGUNTA_MULTIPLE));
            preguntaM.setDescripcion(configPregunta.getPregunta());
            preguntaM.setRespuestas(this.crearObjetoRespuesta(configPregunta, preguntaM));
            return preguntaM;
        }).forEachOrdered((preguntaM) -> {
            preguntasExamen.add(preguntaM);
        });

        return preguntasExamen;
    }

    /**
     * Método privado que crea la relación entre las preguntas y sus respuestas
     * que el usuario configura para la creación del examen.
     *
     * @param configPregunta Objeto que contiene la información de la pregunta
     * que se llena en la vista.
     * @param pregunta Objeto que contiene la información de la entidad de la
     * base de datos.
     * @return la lista de respuestas creadas para las diferentes preguntas que
     * se asignan al examen.
     */
    private Set<Respuesta> crearObjetoRespuesta(ConfiguracionPregunta configPregunta, Pregunta pregunta) {
        Set<Respuesta> respuestas = new HashSet<>();
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

    public Puesto getPuestoE() {
        return puestoE;
    }

    public void setPuestoE(Puesto puestoE) {
        this.puestoE = puestoE;
    }

    public ExamenDTO getExamenDTO() {
        return examenDTO;
    }

    public void setExamenDTO(ExamenDTO examenDTO) {
        this.examenDTO = examenDTO;
    }

    public Map<String, CatalogoParametro> getMapParametrosPreguntas() {
        return mapParametrosPreguntas;
    }

    public Map<String, CatalogoParametro> getMapParametrosExamenes() {
        return mapParametrosExamenes;
    }

}
