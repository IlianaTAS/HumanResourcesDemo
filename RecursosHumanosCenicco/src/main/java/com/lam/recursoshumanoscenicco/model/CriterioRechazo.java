package com.lam.recursoshumanoscenicco.model;
// Generated 16/09/2018 08:26:45 PM by Hibernate Tools 5.3.1.Final

/**
 * CriterioRechazo generated by hbm2java
 */
public class CriterioRechazo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8150308967114357580L;
	private long idCriterioRechazo;
	private String descripcion;
	private String nivel;

	public CriterioRechazo() {
	}

	public CriterioRechazo(long idCriterioRechazo, String descripcion, String nivel) {
		this.idCriterioRechazo = idCriterioRechazo;
		this.descripcion = descripcion;
		this.nivel = nivel;
	}

	public long getIdCriterioRechazo() {
		return this.idCriterioRechazo;
	}

	public void setIdCriterioRechazo(long idCriterioRechazo) {
		this.idCriterioRechazo = idCriterioRechazo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

}
