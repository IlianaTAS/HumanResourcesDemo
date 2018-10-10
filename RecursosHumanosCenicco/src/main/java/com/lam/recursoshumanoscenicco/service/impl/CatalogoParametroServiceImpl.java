package com.lam.recursoshumanoscenicco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lam.recursoshumanoscenicco.dao.CatalogoParametroDao;
import com.lam.recursoshumanoscenicco.exception.DaoException;
import com.lam.recursoshumanoscenicco.exception.ServiceException;
import com.lam.recursoshumanoscenicco.model.CatalogoParametro;
import com.lam.recursoshumanoscenicco.service.CatalogoParametroService;

@Service("catalogoParametroService")
public class CatalogoParametroServiceImpl extends GenericAbstractService<CatalogoParametro, Long> implements CatalogoParametroService {

	private CatalogoParametroDao catalogoParametroDao;
	
	@Autowired
	public CatalogoParametroServiceImpl(CatalogoParametroDao catalogoParametroDao) {
		super(catalogoParametroDao);
		this.catalogoParametroDao=catalogoParametroDao;
	}

    @Override
    public CatalogoParametro findParametroBy(String valor) throws ServiceException{
        try {
            return this.catalogoParametroDao.findParametroBy(valor);
        } catch (DaoException e) {
            throw new ServiceException(e.getErrorCodigo(), "ServiceException error al consultar parámetro", e);
        }
    }

}
