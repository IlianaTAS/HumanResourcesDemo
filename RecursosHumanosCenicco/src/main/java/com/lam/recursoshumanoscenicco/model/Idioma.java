package com.lam.recursoshumanoscenicco.model;
// Generated 16/09/2018 08:26:45 PM by Hibernate Tools 5.3.1.Final

/**
 * Idioma generated by hbm2java
 */
public class Idioma implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1795139933615509669L;
	private long idIdioma;
	private String descripcion;

	public Idioma() {
	}

	public Idioma(long idIdioma, String descripcion) {
		this.idIdioma = idIdioma;
		this.descripcion = descripcion;
	}

	public long getIdIdioma() {
		return this.idIdioma;
	}

	public void setIdIdioma(long idIdioma) {
		this.idIdioma = idIdioma;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
