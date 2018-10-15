/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.recursoshumanoscenicco.controller;

import com.lam.recursoshumanoscenicco.exception.ServiceException;
import com.lam.recursoshumanoscenicco.model.Pais;
import com.lam.recursoshumanoscenicco.service.PaisService;
import com.lam.recursoshumanoscenicco.utils.Mensajes;
import com.lam.recursoshumanoscenicco.utils.Util;
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
public class PaisController implements Serializable {

    private final static Logger logger = LoggerFactory.getLogger(PaisController.class);

    private PaisService paisService;

    private List<Pais> listaPaises;
    private Pais pais;

    @PostConstruct
    public void init() {
        this.listaPaises = new ArrayList<>();
        this.pais = new Pais();

        this.consultarPaises();
    }

    /**
     * Método para la consulta de todos los países registrados por el usuario.
     */
    public void consultarPaises() {
        try {
            this.listaPaises = this.paisService.buscarTodo();
        } catch (ServiceException e) {
            logger.error("Error en el servicio [paisService.buscarTodo]", e);
            this.addMessage(Mensajes.ERROR_CONSULTAR_PAIS, false);
        }
    }

    /**
     * Método que se expone al front para la creación de países.
     *
     * @param event
     */
    public void crearPais(ActionEvent event) {
        try {
            Long idPais = this.paisService.guardar(this.pais);
            logger.info("El pais que se crea: " + Util.debugImprimirContenidoObjecto(this.pais));
            if (idPais != null) {
                this.addMessage(Mensajes.EXITO_CREAR_PAIS, true);
            } else {
                this.addMessage(Mensajes.ERROR_CREAR_PAIS, false);
            }
            this.init();
        } catch (ServiceException e) {
            logger.error("Error Servicio [paisService.guardar]", e);
            this.addMessage(Mensajes.ERROR_CREAR_PAIS, false);
        }
    }

    /**
     * Método que se expone al front para la modificación de países.
     *
     * @param event
     */
    public void modificarPais(ActionEvent event) {
        try {
            this.paisService.actualizar(this.pais);
            logger.info("El pais que se modifica: " + Util.debugImprimirContenidoObjecto(this.pais));
            this.addMessage(Mensajes.EXITO_MODIFCAR_PAIS, true);
            this.init();
        } catch (ServiceException e) {
            logger.error("Error Servicio [paisService.actualizar]", e);
            this.addMessage(Mensajes.ERROR_MODIFICAR_PAIS, false);
        }
    }

    /**
     * Método que se expone al front para la eliminación de países.
     *
     * @param event
     */
    public void eliminarPais(ActionEvent event) {
        try {
            this.paisService.eliminar(this.pais);
            this.addMessage(Mensajes.EXITO_ELIMINAR_PAIS, true);
            logger.info("El pais que se elimina: " + Util.debugImprimirContenidoObjecto(this.pais));
            this.init();
        } catch (ServiceException e) {
            logger.error("Error Servicio [paisService.eliminar]", e);
            this.addMessage(Mensajes.ERROR_ELIMINAR_PAIS, false);
        }
    }

    /**
     * Método para instanciar el objeto país que se va a eliminar del catálogo.
     * @param event 
     */
    public void objetoEliminar(ActionEvent event) {
        this.pais = (Pais) event.getComponent().getAttributes().get("paisEliminar");
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

    public PaisService getPaisService() {
        return paisService;
    }

    public void setPaisService(PaisService paisService) {
        this.paisService = paisService;
    }

    public List<Pais> getListaPaises() {
        return listaPaises;
    }

    public void setListaPaises(List<Pais> listaPaises) {
        this.listaPaises = listaPaises;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

}
