package com.lam.recursoshumanoscenicco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lam.recursoshumanoscenicco.dao.RolDao;
import com.lam.recursoshumanoscenicco.model.Rol;
import com.lam.recursoshumanoscenicco.service.RolService;

@Service
public class RolServiceImpl extends GenericAbstractService<Rol, Long> implements RolService{
	
	private RolDao rolDao;
	
	@Autowired
	public RolServiceImpl(RolDao rolDao) {
		super(rolDao);
		this.rolDao=rolDao;
	}

}
