package com.lam.recursoshumanoscenicco.model;

import java.io.Serializable;

public class Rol implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4383444897260769002L;
	private long idRol;
	private String nombre;
	private String descripcion;
	
	private Perfil perfil;
	
	public Rol() {
		
	}

	public long getIdRol() {
		return idRol;
	}

	public void setIdRol(long idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	
}
