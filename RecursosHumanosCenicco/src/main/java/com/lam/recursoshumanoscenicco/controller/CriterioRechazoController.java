/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.recursoshumanoscenicco.controller;

import com.lam.recursoshumanoscenicco.exception.ServiceException;
import com.lam.recursoshumanoscenicco.model.CriterioRechazo;
import com.lam.recursoshumanoscenicco.service.CriterioRechazoService;
import com.lam.recursoshumanoscenicco.utils.Mensajes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author iperez
 */
public class CriterioRechazoController implements Serializable {

    private final static Logger logger = LoggerFactory.getLogger(CriterioRechazoController.class);

    private CriterioRechazoService criterioRechazoService;

    private List<CriterioRechazo> listaCriteriosRechazo;
    private CriterioRechazo criterioRechazo;
    
    private boolean nivelRechazo;
    
    @PostConstruct
    public void init() {
        this.listaCriteriosRechazo = new ArrayList<>();
        this.criterioRechazo = new CriterioRechazo();
        
        this.nivelRechazo = false;
        this.consultarCriterioRechazo();
    }

    /**
     * Método para consultar todos los criterios de rechazo registrados por el
     * usuario.
     */
    public void consultarCriterioRechazo() {
        try {
            this.listaCriteriosRechazo = this.criterioRechazoService.buscarTodo();
        } catch (ServiceException e) {
            logger.error("Error en el servicio [criterioRechazoService.buscarTodo]", e);
            this.addMessage(Mensajes.ERROR_CONSULTAR_CRITERIO_RECHAZO, false);
        }
    }

    /**
     * Método que se expone al front para la creación de criterios de rechazo.
     *
     * @param event
     */
    public void crearCriterioRechazo(ActionEvent event) {
        try {
            System.out.println("DEBUG IIPG --> Lo que regresa en nivel de rechazo: " + this.nivelRechazo);
            
            this.criterioRechazo.setNivel(this.nivelRechazo ? "Grave" : "Moderado");
            Long idCriterio = this.criterioRechazoService.guardar(criterioRechazo);
            if (idCriterio != null) {
                this.addMessage(Mensajes.EXITO_CREAR_CRITERIO_RECHAZO, true);
            } else {
                this.addMessage(Mensajes.ERROR_CREAR_CRITERIO_RECHAZO, false);
            }
            this.init();
        } catch (ServiceException e) {
            logger.error("Error Servicio [criterioRechazoService.guardar]", e);
            this.addMessage(Mensajes.ERROR_CREAR_CRITERIO_RECHAZO, false);
        }
    }

    /**
     * Método que se expone al front para la modificación de criterios de
     * rechazo.
     *
     * @param event
     */
    public void modificarCriterioRechazo(ActionEvent event) {
        try {
            System.out.println("DEBUG IIPG --> Lo que regresa en nivel de rechazo: " + this.nivelRechazo);
            
            this.criterioRechazo.setNivel(this.nivelRechazo ? "Grave" : "Moderado");
            this.criterioRechazoService.actualizar(criterioRechazo);
            this.init();
            this.addMessage(Mensajes.EXITO_MODIFICAR_CRITERIO_RECHAZO, true);
        } catch (ServiceException e) {
            logger.error("Error Servicio [criterioRechazoService.actualizar]", e);
            this.addMessage(Mensajes.ERROR_MODIFICAR_CRITERIO_RECHAZO, false);
        }
    }

    /**
     * Método que se expone al front para eliminar el criterio de rechazo.
     *
     * @param event
     */
    public void eliminarCriterioRechazo(ActionEvent event) {
        try {
            this.criterioRechazoService.eliminar(criterioRechazo);
            this.init();
            this.addMessage(Mensajes.EXITO_MODIFICAR_CRITERIO_RECHAZO, true);
        } catch (ServiceException e) {
            logger.error("Error Servicio [criterioRechazoService.eliminar]", e);
            this.addMessage(Mensajes.ERROR_MODIFICAR_CRITERIO_RECHAZO, false);
        }
    }

    /**
     * Método para instanciar el objeto criterio de rechazo que se va a eliminar
     * del catálogo.
     *
     * @param event JSF parametro.
     */
    public void objetoEliminar(ActionEvent event) {
        this.criterioRechazo = (CriterioRechazo) event.getComponent().getAttributes().get("criterioRechazoEliminar");
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

    public CriterioRechazoService getCriterioRechazoService() {
        return criterioRechazoService;
    }

    public void setCriterioRechazoService(CriterioRechazoService criterioRechazoService) {
        this.criterioRechazoService = criterioRechazoService;
    }

    public List<CriterioRechazo> getListaCriteriosRechazo() {
        return listaCriteriosRechazo;
    }

    public void setListaCriteriosRechazo(List<CriterioRechazo> listaCriteriosRechazo) {
        this.listaCriteriosRechazo = listaCriteriosRechazo;
    }

    public CriterioRechazo getCriterioRechazo() {
        return criterioRechazo;
    }

    public void setCriterioRechazo(CriterioRechazo criterioRechazo) {
        this.criterioRechazo = criterioRechazo;
    }

    public boolean isNivelRechazo() {
        return nivelRechazo;
    }

    public void setNivelRechazo(boolean nivelRechazo) {
        this.nivelRechazo = nivelRechazo;
    }

}
