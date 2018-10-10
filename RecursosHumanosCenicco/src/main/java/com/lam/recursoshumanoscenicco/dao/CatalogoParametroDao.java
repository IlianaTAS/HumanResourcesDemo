package com.lam.recursoshumanoscenicco.dao;

import com.lam.recursoshumanoscenicco.exception.DaoException;
import com.lam.recursoshumanoscenicco.model.CatalogoParametro;

public interface CatalogoParametroDao extends GenericDao<CatalogoParametro, Long> {
    
    CatalogoParametro findParametroBy(String valor) throws DaoException;

}
