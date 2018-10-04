package com.lam.recursoshumanoscenicco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lam.recursoshumanoscenicco.dao.EstadoDao;
import com.lam.recursoshumanoscenicco.model.Estado;
import com.lam.recursoshumanoscenicco.service.EstadoService;

@Service("estadoService")
public class EstadoServiceImpl extends GenericAbstractService<Estado, Long> implements EstadoService{

	private EstadoDao estadoDao;
	
	@Autowired
	public EstadoServiceImpl(EstadoDao estadoDao) {
		super(estadoDao);
		this.estadoDao=estadoDao;
	}
}
