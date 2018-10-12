package com.lam.recursoshumanoscenicco.dao;

import com.lam.recursoshumanoscenicco.exception.DaoException;
import com.lam.recursoshumanoscenicco.model.CatalogoParametro;
import com.lam.recursoshumanoscenicco.model.Examen;
import java.util.List;

public interface ExamenDao extends GenericDao<Examen, Long>{
    
    List<Examen> buscarExamenesPor(CatalogoParametro catalogoParametro) throws DaoException;

}
