package com.lam.recursoshumanoscenicco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lam.recursoshumanoscenicco.dao.AlarmaDao;
import com.lam.recursoshumanoscenicco.model.Alarma;
import com.lam.recursoshumanoscenicco.service.AlarmaService;

@Service
public class AlarmaServiceImpl extends GenericAbstractService<Alarma, Long> implements AlarmaService {
	
	private AlarmaDao alarmaDao;
	
	@Autowired
	public AlarmaServiceImpl(AlarmaDao alarmaDao) {
		super(alarmaDao);
		this.alarmaDao=alarmaDao;
	}

	
}
