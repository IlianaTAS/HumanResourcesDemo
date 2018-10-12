package com.lam.recursoshumanoscenicco.service;

import com.lam.recursoshumanoscenicco.exception.ServiceException;
import com.lam.recursoshumanoscenicco.model.CatalogoParametro;
import com.lam.recursoshumanoscenicco.model.Examen;
import java.util.List;

public interface ExamenService extends GenericService<Examen, Long>{
    
    public List<Examen> buscarExamenesPor(CatalogoParametro catalogoParametro) throws ServiceException;

}
