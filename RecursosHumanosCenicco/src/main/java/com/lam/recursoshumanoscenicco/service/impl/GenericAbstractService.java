package com.lam.recursoshumanoscenicco.service.impl;

import java.io.Serializable;
import java.util.List;

import com.lam.recursoshumanoscenicco.dao.GenericDao;
import com.lam.recursoshumanoscenicco.exception.DaoException;
import com.lam.recursoshumanoscenicco.exception.ServiceException;
import com.lam.recursoshumanoscenicco.service.GenericService;


public abstract class GenericAbstractService<TYPE extends Serializable, PK extends Serializable> implements GenericService<TYPE,PK>{

	private GenericDao<TYPE, PK> dao;
	
	GenericAbstractService(GenericDao<TYPE, PK> dao ){
		this.dao=dao;
	}
	
	public PK guardar(TYPE object) throws ServiceException {
		try {
			return dao.save(object);
		} catch (DaoException e) {
			throw new ServiceException(e.getErrorCodigo(),"Error guardar ".concat(object.getClass().getName()),e);
		}
	}
	
	public List<TYPE> buscarTodo() throws ServiceException{
		try {
			return dao.findAll();
		} catch (DaoException e) {
			throw new ServiceException(e.getErrorCodigo(), e.getMensaje(), e);
		}
	}
	
}
