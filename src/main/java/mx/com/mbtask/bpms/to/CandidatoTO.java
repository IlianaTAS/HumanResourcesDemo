/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.mbtask.bpms.to;

/**
 *
 * @author iperez
 */
public class CandidatoTO {
    
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String criterioRechazo;
    private String estatus;
    private String analista;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCriterioRechazo() {
        return criterioRechazo;
    }

    public void setCriterioRechazo(String criterioRechazo) {
        this.criterioRechazo = criterioRechazo;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getAnalista() {
        return analista;
    }

    public void setAnalista(String analista) {
        this.analista = analista;
    }
    
}
