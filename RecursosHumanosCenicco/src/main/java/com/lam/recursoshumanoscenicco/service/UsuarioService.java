package com.lam.recursoshumanoscenicco.service;

import com.lam.recursoshumanoscenicco.model.Usuario;

public interface UsuarioService {

	public Long saveUsuario(Usuario usuario);
	
	public Usuario findUsuarioBy(String nombreUsuario);
	
}
