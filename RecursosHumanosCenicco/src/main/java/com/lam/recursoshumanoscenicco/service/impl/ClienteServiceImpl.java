package com.lam.recursoshumanoscenicco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.lam.recursoshumanoscenicco.dao.ClienteDao;
import com.lam.recursoshumanoscenicco.model.Cliente;
import com.lam.recursoshumanoscenicco.service.ClienteService;

@Service
public class ClienteServiceImpl extends GenericAbstractService<Cliente, Long> implements ClienteService{

	private ClienteDao clienteDao;
	
	@Autowired
	public ClienteServiceImpl(ClienteDao clienteDao) {
		super(clienteDao);
		this.clienteDao=clienteDao;
	}
	
	
}

