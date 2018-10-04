package com.lam.recursoshumanoscenicco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lam.recursoshumanoscenicco.dao.ExamenDao;
import com.lam.recursoshumanoscenicco.model.Examen;
import com.lam.recursoshumanoscenicco.service.ExamenService;

@Service("examenService")
public class ExamenServiceImpl extends GenericAbstractService<Examen, Long> implements ExamenService{
	
	private ExamenDao examenDao;
	
	@Autowired
	public ExamenServiceImpl(ExamenDao examenDao) {
		super(examenDao);
		this.examenDao=examenDao;
	}

}
