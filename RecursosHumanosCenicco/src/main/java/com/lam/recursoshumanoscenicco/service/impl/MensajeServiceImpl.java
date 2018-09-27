package com.lam.recursoshumanoscenicco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lam.recursoshumanoscenicco.dao.MensajeDao;
import com.lam.recursoshumanoscenicco.model.Mensaje;
import com.lam.recursoshumanoscenicco.service.MensajeService;

@Service
public class MensajeServiceImpl extends GenericAbstractService<Mensaje, Long> implements MensajeService{

	private MensajeDao mensajeDao;
	
	@Autowired
	public MensajeServiceImpl(MensajeDao mensajeDao) {
		super(mensajeDao);
		this.mensajeDao=mensajeDao;
	}
}
