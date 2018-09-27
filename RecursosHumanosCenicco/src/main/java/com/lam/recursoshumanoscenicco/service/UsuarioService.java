package com.lam.recursoshumanoscenicco.service;

import com.lam.recursoshumanoscenicco.exception.ServiceException;
import com.lam.recursoshumanoscenicco.model.Usuario;

public interface UsuarioService extends GenericService<Usuario, Long>{

	public Long saveUsuario(Usuario usuario) throws ServiceException;
	
	public Usuario findUsuarioBy(String nombreUsuario) throws ServiceException;
	
}
