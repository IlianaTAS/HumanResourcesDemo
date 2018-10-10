package com.lam.recursoshumanoscenicco.dao;

import com.lam.recursoshumanoscenicco.exception.DaoException;
import com.lam.recursoshumanoscenicco.model.CatalogoParametro;
import java.util.Map;

public interface CatalogoParametroDao extends GenericDao<CatalogoParametro, Long> {
    
    Map<String,CatalogoParametro> findParametroBy(String parametro) throws DaoException;

}
