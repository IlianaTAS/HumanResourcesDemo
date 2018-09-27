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
	
	
	public TYPE buscarPorId(PK id) throws ServiceException{
		try {
			return dao.find(id);
		} catch (DaoException e) {
			throw new ServiceException(e.getErrorCodigo(), "Error al buscar registro por id ".concat(id.toString()), e);
		}
	}
	
	public void eliminar(TYPE objecto) throws ServiceException{
		try {
			dao.delete(objecto);
		} catch (DaoException e) {
			throw new ServiceException(e.getErrorCodigo(), 
					"Error al eliminar ".concat(objecto.getClass().getSimpleName()), e);
		}
	}
	
	public void actualizar(TYPE objecto) throws ServiceException{
		try {
			dao.update(objecto);
		} catch (DaoException e) {
			throw new ServiceException(e.getErrorCodigo(), e.getMensaje(), e);
		}
	}
	
	public void guardarOActualizar(TYPE objecto) throws ServiceException{
		try {
			dao.saveOrUpdate(objecto);
		} catch (DaoException e) {
			throw new ServiceException(e.getErrorCodigo(), e.getMensaje(), e);
		}
	}
	
	public void buscarPorObjecto(TYPE objecto) throws ServiceException{
		try {
			dao.findByExample(objecto);
		} catch (DaoException e) {
			throw new ServiceException(e.getErrorCodigo(), e.getMensaje(), e);
		}
	}
}
