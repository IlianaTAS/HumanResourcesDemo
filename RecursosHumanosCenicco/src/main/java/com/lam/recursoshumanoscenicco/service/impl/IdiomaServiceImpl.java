package com.lam.recursoshumanoscenicco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lam.recursoshumanoscenicco.dao.IdiomaDao;
import com.lam.recursoshumanoscenicco.model.Idioma;
import com.lam.recursoshumanoscenicco.service.IdiomaService;

@Service("idiomaService")
public class IdiomaServiceImpl extends GenericAbstractService<Idioma, Long> implements IdiomaService{

	private IdiomaDao idiomaDao;
	
	@Autowired
	public IdiomaServiceImpl(IdiomaDao idiomaDao) {
		super(idiomaDao);
		this.idiomaDao=idiomaDao;
	}
}
