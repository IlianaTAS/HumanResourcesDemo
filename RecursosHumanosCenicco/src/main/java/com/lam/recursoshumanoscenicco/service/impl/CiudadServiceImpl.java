package com.lam.recursoshumanoscenicco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lam.recursoshumanoscenicco.dao.CiudadDao;
import com.lam.recursoshumanoscenicco.model.Ciudad;
import com.lam.recursoshumanoscenicco.service.CiudadService;

@Service
public class CiudadServiceImpl extends GenericAbstractService<Ciudad, Long> implements CiudadService{

	private CiudadDao ciudadDao;
	
	@Autowired
	public CiudadServiceImpl(CiudadDao ciudadDao) {
		super(ciudadDao);
		this.ciudadDao=ciudadDao;
	}
}
