package com.lam.recursoshumanoscenicco.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Perfil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3159460498400635302L;
	private Long idPerfil;
	private String nombre;
	private String descripcion;
	
	private Set<Rol> rol = new HashSet<>();
	
	public  Perfil() {
		
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

	public Set<Rol> getRol() {
		return rol;
	}

	public void setRol(Set<Rol> rol) {
		this.rol = rol;
	}


	public Long getIdPerfil() {
		return idPerfil;
	}


	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}


}
