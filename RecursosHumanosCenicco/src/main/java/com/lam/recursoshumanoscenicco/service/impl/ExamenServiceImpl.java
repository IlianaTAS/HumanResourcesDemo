package com.lam.recursoshumanoscenicco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lam.recursoshumanoscenicco.dao.ExamenDao;
import com.lam.recursoshumanoscenicco.exception.DaoException;
import com.lam.recursoshumanoscenicco.exception.ServiceException;
import com.lam.recursoshumanoscenicco.model.CatalogoParametro;
import com.lam.recursoshumanoscenicco.model.Examen;
import com.lam.recursoshumanoscenicco.service.ExamenService;
import java.util.List;

@Service("examenService")
public class ExamenServiceImpl extends GenericAbstractService<Examen, Long> implements ExamenService{
	
	private ExamenDao examenDao;
	
	@Autowired
	public ExamenServiceImpl(ExamenDao examenDao) {
		super(examenDao);
		this.examenDao=examenDao;
	}

    @Override
    public List<Examen> buscarExamenesPor(CatalogoParametro catalogoParametro) throws ServiceException{
            try {
                return examenDao.buscarExamenesPor(catalogoParametro);
            } catch (DaoException e) {
               throw new ServiceException(e.getErrorCodigo(), "ServiceException Error al consultar los exámenes", e);
            }
    }

}
