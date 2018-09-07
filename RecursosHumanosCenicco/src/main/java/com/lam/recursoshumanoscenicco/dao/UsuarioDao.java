package com.lam.recursoshumanoscenicco.dao;

import org.springframework.transaction.annotation.Transactional;

import com.lam.recursoshumanoscenicco.model.Usuario;

@Transactional
public interface UsuarioDao extends GenericDao<Usuario, Long>{

	Usuario findUsuarioBy(String nombreUsuario);

}
