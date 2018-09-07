package com.lam.recursoshumanoscenicco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lam.recursoshumanoscenicco.dao.UsuarioDao;
import com.lam.recursoshumanoscenicco.model.Usuario;
import com.lam.recursoshumanoscenicco.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioDao  usuarioDao;
	
	public Long saveUsuario(Usuario usuario) {
		try {
			return usuarioDao.save(usuario);			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Usuario findUsuarioBy(String nombreUsuario) {
		return usuarioDao.findUsuarioBy(nombreUsuario);
	}

}
