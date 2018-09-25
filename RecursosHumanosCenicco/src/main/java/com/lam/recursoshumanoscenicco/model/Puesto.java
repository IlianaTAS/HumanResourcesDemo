package com.lam.recursoshumanoscenicco.model;
// Generated 16/09/2018 08:26:45 PM by Hibernate Tools 5.3.1.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Puesto generated by hbm2java
 */
public class Puesto implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1935496103622323942L;
	private long idPuesto;
	private String descripcion;
	private Set<Examen> examenes = new HashSet<Examen>();

	public Puesto() {
	}

	public Puesto(long idPuesto, String descripcion) {
		this.idPuesto = idPuesto;
		this.descripcion = descripcion;
	}

	public Puesto(long idPuesto, String descripcion, Set<Examen> examenes) {
		this.idPuesto = idPuesto;
		this.descripcion = descripcion;
		this.examenes = examenes;
	}

	public long getIdPuesto() {
		return this.idPuesto;
	}

	public void setIdPuesto(long idpuesto) {
		this.idPuesto = idpuesto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Examen> getExamenes() {
		return this.examenes;
	}

	public void setExamenes(Set<Examen> examenes) {
		this.examenes = examenes;
	}

}