/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.mbtask.bpms.to;

import java.util.Date;

/**
 *
 * @author iperez
 */
public class ProcesosPendientesTO {
    
    private String cliente;
    private String posicion;
    private String candidato;
    private String procesoPendiente;
    private Date fechaUltimoProceso;

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getCandidato() {
        return candidato;
    }

    public void setCandidato(String candidato) {
        this.candidato = candidato;
    }

    public String getProcesoPendiente() {
        return procesoPendiente;
    }

    public void setProcesoPendiente(String procesoPendiente) {
        this.procesoPendiente = procesoPendiente;
    }

    public Date getFechaUltimoProceso() {
        return fechaUltimoProceso;
    }

    public void setFechaUltimoProceso(Date fechaUltimoProceso) {
        this.fechaUltimoProceso = fechaUltimoProceso;
    }

 
    
    
    
}
