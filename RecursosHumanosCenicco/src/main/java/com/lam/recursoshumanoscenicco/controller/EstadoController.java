/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.recursoshumanoscenicco.controller;

import com.lam.recursoshumanoscenicco.exception.ServiceException;
import com.lam.recursoshumanoscenicco.model.Estado;
import com.lam.recursoshumanoscenicco.model.Pais;
import com.lam.recursoshumanoscenicco.service.EstadoService;
import com.lam.recursoshumanoscenicco.service.PaisService;
import com.lam.recursoshumanoscenicco.utils.Mensajes;
import com.lam.recursoshumanoscenicco.utils.Util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
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
public class EstadoController implements Serializable {

    private final static Logger logger = LoggerFactory.getLogger(PaisController.class);

    private EstadoService estadoService;
    private PaisService paisService;

    private List<Estado> listaEstados;
    private List<Pais> listaPaises;
    private Estado estado;

    @PostConstruct
    public void init() {
        this.listaEstados = new ArrayList<>();
        this.estado = new Estado();

        this.consultarEntidades();
    }

    /**
     * Método para la consulta de las entidades que se requieren para la carga
     * incial de la pantalla de consulta de estados.
     */
    public void consultarEntidades() {
        try {
            this.listaEstados = this.estadoService.buscarTodo();
            this.listaPaises = this.paisService.buscarTodo();
        } catch (ServiceException e) {
            logger.error("Error en el servicio [estadoService.buscarTodo]", e);
            this.addMessage(Mensajes.ERROR_CONSULTAR_ENTIDADES, false);
        }
    }

    /**
     * Método que se expone
     * @param event 
     */
    public void crearEstado(ActionEvent event) {
        try {
            Long idPais = this.estado.getPais().getIdPais();
            this.estado.setPais(this.paisService.buscarPorId(idPais));
            Long idEstado = this.estadoService.guardar(this.estado);
            logger.info("El estado que se crea: " + Util.debugImprimirContenidoObjecto(this.estado));
            if (idEstado != null) {
                this.addMessage(Mensajes.EXITO_CREAR_PAIS, true);
            } else {
                this.addMessage(Mensajes.ERROR_CREAR_PAIS, false);
            }
            this.init();
        } catch (ServiceException e) {
            logger.error("Error en el servicio [estadoService.guardar]", e);
        }

    }

    public void modificarEstado(ActionEvent event) {
        try {
            Long idPais = this.estado.getPais().getIdPais();
            this.estado.setPais(this.paisService.buscarPorId(idPais));
            this.estadoService.actualizar(this.estado);
            logger.info("El estado que se modifica: " + Util.debugImprimirContenidoObjecto(this.estado));
            this.addMessage(Mensajes.EXITO_MODIFCAR_ESTADO, true);
            this.init();
        } catch (ServiceException e) {
            logger.error("Error Servicio [estadoService.actualizar]", e);
            this.addMessage(Mensajes.ERROR_MODIFICAR_ESTADO, false);
        }

    }

    public void eliminarEstado(ActionEvent event) {
        try {
            this.estadoService.eliminar(this.estado);
            this.addMessage(Mensajes.EXITO_ELIMINAR_ESTADO, true);
            logger.info("El estado que se elimina: " + Util.debugImprimirContenidoObjecto(this.estado));
            this.init();
        } catch (ServiceException e) {
            logger.error("Error Servicio [estadoService.eliminar]", e);
            this.addMessage(Mensajes.ERROR_ELIMINAR_ESTADO, false);
        }
    }
    
    public void objetoEliminar(ActionEvent event) {
        this.estado = (Estado) event.getComponent().getAttributes().get("estadoEliminar");
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

    public EstadoService getEstadoService() {
        return estadoService;
    }

    public void setEstadoService(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    public PaisService getPaisService() {
        return paisService;
    }

    public void setPaisService(PaisService paisService) {
        this.paisService = paisService;
    }

    public List<Estado> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(List<Estado> listaEstados) {
        this.listaEstados = listaEstados;
    }

    public List<Pais> getListaPaises() {
        return listaPaises;
    }

    public void setListaPaises(List<Pais> listaPaises) {
        this.listaPaises = listaPaises;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
