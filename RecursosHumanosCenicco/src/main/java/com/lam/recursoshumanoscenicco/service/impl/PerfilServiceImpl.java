package com.lam.recursoshumanoscenicco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lam.recursoshumanoscenicco.dao.PerfilDao;
import com.lam.recursoshumanoscenicco.model.Perfil;
import com.lam.recursoshumanoscenicco.service.PerfilService;

@Service
public class PerfilServiceImpl extends GenericAbstractService<Perfil, Long> implements PerfilService{
	
	private PerfilDao perfilDao;
	
	@Autowired
	public PerfilServiceImpl(PerfilDao perfilDao) {
		super(perfilDao);
		this.perfilDao=perfilDao;
	}

}
