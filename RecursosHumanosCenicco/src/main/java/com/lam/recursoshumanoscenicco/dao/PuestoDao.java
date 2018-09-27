package com.lam.recursoshumanoscenicco.dao;

import com.lam.recursoshumanoscenicco.exception.DaoException;
import com.lam.recursoshumanoscenicco.model.Puesto;
import java.util.List;

public interface PuestoDao extends GenericDao<Puesto, Long> {
    
    /**
     * Método que regresa el universo de registros en la tabla PUESTO.
     * @return lista con la información de la base de datos.
     * @throws com.lam.recursoshumanoscenicco.exception.DaoException
     *      Propagación de excepción que se trata en caso de error con la comunicación con ORACLE.
     */
    List<Puesto> findPuestos() throws DaoException;

}
