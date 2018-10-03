/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.recursoshumanoscenicco.controller;

import com.lam.recursoshumanoscenicco.exception.ServiceException;
import com.lam.recursoshumanoscenicco.model.Puesto;
import com.lam.recursoshumanoscenicco.service.PuestoService;
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
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author iperez
 */
public class PuestoController implements Serializable {

    private final static Logger logger = LoggerFactory.getLogger(PuestoController.class);

    @Autowired
    private PuestoService puestoService;
    
    private List<Puesto> listaPuestos;
    private Puesto puesto;

    @PostConstruct
    public void init() {
        this.listaPuestos = new ArrayList<>();

        this.consultarPuestos();
    }

    /**
     * Método para consultar todos los puestos registrados por el usuario.
     */
    public void consultarPuestos() {
        try {
            this.listaPuestos = this.puestoService.buscarTodo();
        } catch (ServiceException e) {
            logger.error("Error en el servicio [puestoService.buscarTodo]", e);
            this.addMessage(Mensajes.ERROR_CONSULTAR_PUESTO, false);
        }
    }

    /**
     * Método que se expone al front para la creación de puestos.
     *
     * @param event
     */
    public void crearPuesto(ActionEvent event) {
        try {
            Long idPuesto = this.puestoService.guardar(puesto);
            if (idPuesto != null) {
                this.addMessage(Mensajes.EXITO_CREAR_PUESTO, true);
            } else {
                this.addMessage(Mensajes.ERROR_CREAR_PUESTO, false);
            }
            this.init();
        } catch (ServiceException e) {
            logger.error("Error Servicio [puestoService.guardar]", e);
            this.addMessage(Mensajes.ERROR_CREAR_PUESTO, false);
        }
    }

    /**
     * Método que se expone al front para la modificación de puestos.
     *
     * @param event
     */
    public void modificarPuesto(ActionEvent event) {
        try {
            this.puestoService.actualizar(puesto);
            this.addMessage(Mensajes.EXITO_MODIFICAR_PUESTO, true);
        } catch (ServiceException e) {
            logger.error("Error Servicio [puestoService.actualizar]", e);
            this.addMessage(Mensajes.ERROR_MODIFICAR_PUESTO, false);
        }
    }

    /**
     * Método que se expone al front para eliminar el puesto.
     *
     * @param event
     */
    public void eliminarPuesto(ActionEvent event) {
        try {
            this.puestoService.eliminar(puesto);
            this.addMessage(Mensajes.EXITO_MODIFICAR_PUESTO, true);
        } catch (ServiceException e) {
            logger.error("Error Servicio [puestoService.eliminar]", e);
            this.addMessage(Mensajes.ERROR_MODIFICAR_PUESTO, false);
        }
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

    public PuestoService getPuestoService() {
        return puestoService;
    }

    public void setPuestoService(PuestoService puestoService) {
        this.puestoService = puestoService;
    }

    public List<Puesto> getListaPuestos() {
        return listaPuestos;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

}
