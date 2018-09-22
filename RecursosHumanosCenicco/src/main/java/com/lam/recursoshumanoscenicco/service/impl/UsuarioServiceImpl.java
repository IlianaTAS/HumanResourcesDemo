package com.lam.recursoshumanoscenicco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lam.recursoshumanoscenicco.dao.UsuarioDao;
import com.lam.recursoshumanoscenicco.exception.DaoException;
import com.lam.recursoshumanoscenicco.exception.ServiceException;
import com.lam.recursoshumanoscenicco.model.Usuario;
import com.lam.recursoshumanoscenicco.service.UsuarioService;

@Service
public class UsuarioServiceImpl extends GenericAbstractService<Usuario, Long> implements UsuarioService{

	private UsuarioDao  usuarioDao;
	
	@Autowired
	public UsuarioServiceImpl(UsuarioDao usuarioDao) {
		super(usuarioDao);
		this.usuarioDao=usuarioDao;
	}
	
	public Long saveUsuario(Usuario usuario) throws ServiceException {
		try {
			return usuarioDao.save(usuario);			
		} catch (DaoException e) {
			throw new ServiceException(e.getErrorCodigo(), "ServiceException Error al crear Usuario", e);
		}
	}

	@Override
	public Usuario findUsuarioBy(String nombreUsuario) throws ServiceException {
		try {
			return usuarioDao.findUsuarioBy(nombreUsuario);
		} catch (DaoException e) {
			throw new ServiceException(e.getErrorCodigo(), "ServiceException erro al consultar usuario", e);
		}
	}

}
