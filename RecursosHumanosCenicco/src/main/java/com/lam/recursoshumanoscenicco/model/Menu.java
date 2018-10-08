package com.lam.recursoshumanoscenicco.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Menu implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2404350956955150063L;

	private Long idMenu;
	
	private String nombre;
	
	private String url;
	
	private String icono;
	
	private String modulo;
	
	private Set<Menu> menus=new HashSet<>();
	
	private Set<Perfil> perfiles=new HashSet<>();
	
	public Menu() {
		
	}

	public Long getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Long idMenu) {
		this.idMenu = idMenu;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

	public Set<Perfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(Set<Perfil> perfiles) {
		this.perfiles = perfiles;
	}
	
	
}
