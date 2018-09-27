package com.lam.recursoshumanoscenicco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lam.recursoshumanoscenicco.dao.CriterioRechazoDao;
import com.lam.recursoshumanoscenicco.model.CriterioRechazo;
import com.lam.recursoshumanoscenicco.service.CriterioRechazoService;

@Service
public class CriterioRechazoServiceImpl extends GenericAbstractService<CriterioRechazo, Long> implements CriterioRechazoService{
	
	private CriterioRechazoDao criterioRechazoDao;
	
	@Autowired
	public CriterioRechazoServiceImpl(CriterioRechazoDao criterioRechazoDao) {
		super(criterioRechazoDao);
		this.criterioRechazoDao=criterioRechazoDao;
	}

}
