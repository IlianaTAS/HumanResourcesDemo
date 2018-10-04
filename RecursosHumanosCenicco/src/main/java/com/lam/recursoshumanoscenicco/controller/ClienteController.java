/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.recursoshumanoscenicco.controller;

import com.lam.recursoshumanoscenicco.exception.ServiceException;
import com.lam.recursoshumanoscenicco.model.Cliente;
import com.lam.recursoshumanoscenicco.service.ClienteService;
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
public class ClienteController implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 43628633074094061L;

	private final static Logger logger = LoggerFactory.getLogger(ClienteController.class);

    private ClienteService clienteService;

    private List<Cliente> listaClientes;
    private Cliente cliente;

    @PostConstruct
    public void init() {
        this.listaClientes = new ArrayList<>();
        this.cliente = new Cliente();

        this.consultarClientes();
    }

    /**
     * Método para consultar todos los clientes registrados por el usuario.
     */
    public void consultarClientes() {
        try {
            this.listaClientes = this.clienteService.buscarTodo();
        } catch (ServiceException e) {
            logger.error("Error en el servicio [clienteService.buscarTodo]", e);
            this.addMessage(Mensajes.ERROR_CONSULTAR_CLIENTE, false);
        }
    }

    /**
     * Método que se expone al front para la creación de clientes.
     *
     * @param event
     */
    public void crearCliente(ActionEvent event) {
        try {
            Long idCliente = this.clienteService.guardar(cliente);
            if (idCliente != null) {
                this.addMessage(Mensajes.EXITO_CREAR_CLIENTE, true);
            } else {
                this.addMessage(Mensajes.ERROR_CREAR_CLIENTE, false);
            }
            this.init();
        } catch (ServiceException e) {
            logger.error("Error Servicio [clienteService.guardar]", e);
            this.addMessage(Mensajes.ERROR_CREAR_CLIENTE, false);
        }
    }

    /**
     * Método que se expone al front para la modificación de clientes.
     *
     * @param event
     */
    public void modificarCliente(ActionEvent event) {
        try {
            this.clienteService.actualizar(cliente);
            this.addMessage(Mensajes.EXITO_MODIFICAR_CLIENTE, true);
        } catch (ServiceException e) {
            logger.error("Error Servicio [clienteService.actualizar]", e);
            this.addMessage(Mensajes.ERROR_MODIFICAR_CLIENTE, false);
        }
    }

    /**
     * Método que se expone al front para eliminar el puesto.
     *
     * @param event
     */
    public void eliminarCliente(ActionEvent event) {
        try {
            this.clienteService.eliminar(cliente);
            this.addMessage(Mensajes.EXITO_MODIFICAR_CLIENTE, true);
        } catch (ServiceException e) {
            logger.error("Error Servicio [clienteService.eliminar]", e);
            this.addMessage(Mensajes.ERROR_MODIFICAR_CLIENTE, false);
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

    public ClienteService getClienteService() {
        return clienteService;
    }

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
