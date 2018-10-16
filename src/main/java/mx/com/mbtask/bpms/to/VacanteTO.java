/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.mbtask.bpms.to;

import java.util.List;

/**
 *
 * @author iperez
 */
public class VacanteTO {
    
    private String numeroVacante;
    private String estatus;
    private String nombreComercial;
    private String ciudad;
    private String puestoNivel;
    private String cantidadProcesados;
    private String cantidadRechazados;
    private List<CandidatoTO> candidatos;

    public String getNumeroVacante() {
        return numeroVacante;
    }

    public void setNumeroVacante(String numeroVacante) {
        this.numeroVacante = numeroVacante;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPuestoNivel() {
        return puestoNivel;
    }

    public void setPuestoNivel(String puestoNivel) {
        this.puestoNivel = puestoNivel;
    }

    public String getCantidadProcesados() {
        return cantidadProcesados;
    }

    public void setCantidadProcesados(String cantidadProcesados) {
        this.cantidadProcesados = cantidadProcesados;
    }

    public String getCantidadRechazados() {
        return cantidadRechazados;
    }

    public void setCantidadRechazados(String cantidadRechazados) {
        this.cantidadRechazados = cantidadRechazados;
    }

    public List<CandidatoTO> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<CandidatoTO> candidatos) {
        this.candidatos = candidatos;
    }
    
    
}
