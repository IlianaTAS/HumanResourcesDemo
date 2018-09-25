package com.lam.recursoshumanoscenicco.service;

import java.util.List;

import com.lam.recursoshumanoscenicco.exception.ServiceException;

public interface GenericService<TYPE, PK> {

	public PK guardar(TYPE object) throws ServiceException;

	List<TYPE> buscarTodo() throws ServiceException;
}
