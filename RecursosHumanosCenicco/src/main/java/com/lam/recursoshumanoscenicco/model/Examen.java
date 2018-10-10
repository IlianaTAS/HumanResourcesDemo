package com.lam.recursoshumanoscenicco.model;
// Generated 16/09/2018 08:26:45 PM by Hibernate Tools 5.3.1.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Examen generated by hbm2java
 */
public class Examen implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5133228928952125282L;
    private long idExamen;
    private Puesto puesto;
    private CatalogoParametro catalogoParametro;
    private String descripcion;
    private String duracion;
    private Set<Pregunta> preguntas = new HashSet<>();

    public Examen() {
        this.puesto = new Puesto();
    }

    public Examen(long idExamen, Puesto puesto, CatalogoParametro catalogoParametro, String descripcion,
            String duracion) {
        this.idExamen = idExamen;
        this.puesto = puesto;
        this.catalogoParametro = catalogoParametro;
        this.descripcion = descripcion;
        this.duracion = duracion;
    }

    public Examen(long idExamen, Puesto puesto, CatalogoParametro catalogoParametro, String descripcion,
            String duracion, Set<Pregunta> preguntas) {
        this.idExamen = idExamen;
        this.puesto = puesto;
        this.catalogoParametro = catalogoParametro;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.preguntas = preguntas;
    }

    public long getIdExamen() {
        return this.idExamen;
    }

    public void setIdExamen(long idExamen) {
        this.idExamen = idExamen;
    }

    public Puesto getPuesto() {
        return this.puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public CatalogoParametro getCatalogoParametro() {
        return this.catalogoParametro;
    }

    public void setCatalogoParametro(CatalogoParametro catalogoParametro) {
        this.catalogoParametro = catalogoParametro;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDuracion() {
        return this.duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Set<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Set<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

}
