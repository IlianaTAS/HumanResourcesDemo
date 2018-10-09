/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.recursoshumanoscenicco.controller;

import com.lam.recursoshumanoscenicco.exception.ServiceException;
import com.lam.recursoshumanoscenicco.model.Examen;
import com.lam.recursoshumanoscenicco.model.Puesto;
import com.lam.recursoshumanoscenicco.service.ExamenService;
import com.lam.recursoshumanoscenicco.service.PuestoService;
import com.lam.recursoshumanoscenicco.to.ConfiguracionPregunta;
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
