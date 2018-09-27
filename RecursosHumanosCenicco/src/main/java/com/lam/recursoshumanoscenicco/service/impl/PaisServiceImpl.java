package com.lam.recursoshumanoscenicco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lam.recursoshumanoscenicco.dao.PaisDao;
import com.lam.recursoshumanoscenicco.model.Pais;
import com.lam.recursoshumanoscenicco.service.PaisService;

@Service
public class PaisServiceImpl extends GenericAbstractService<Pais, Long> implements PaisService {
	
	private PaisDao paisDao;
	
	@Autowired
	public PaisServiceImpl(PaisDao paisDao) {
		super(paisDao);
		this.paisDao=paisDao;
	}

}
