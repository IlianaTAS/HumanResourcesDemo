package com.lam.recursoshumanoscenicco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lam.recursoshumanoscenicco.dao.CatalogoParametroDao;
import com.lam.recursoshumanoscenicco.model.CatalogoParametro;
import com.lam.recursoshumanoscenicco.service.CatalogoParametroService;

@Service
public class CatalogoParametroServiceImpl extends GenericAbstractService<CatalogoParametro, Long> implements CatalogoParametroService {

	private CatalogoParametroDao catalogoParametroDao;
	
	@Autowired
	public CatalogoParametroServiceImpl(CatalogoParametroDao catalogoParametroDao) {
		super(catalogoParametroDao);
		this.catalogoParametroDao=catalogoParametroDao;
	}

}
