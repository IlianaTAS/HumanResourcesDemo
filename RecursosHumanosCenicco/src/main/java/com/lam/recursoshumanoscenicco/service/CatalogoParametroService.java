package com.lam.recursoshumanoscenicco.service;

import com.lam.recursoshumanoscenicco.exception.ServiceException;
import com.lam.recursoshumanoscenicco.model.CatalogoParametro;
import java.util.Map;

public interface CatalogoParametroService extends GenericService<CatalogoParametro, Long> {

    /**
     * Interfaz de servicio para obtener el parámetro de la base de datos.
     *
     * @param parametro Columna de busqueda.
     * @return Objeto encontrado en la base de datos.
     * @throws com.lam.recursoshumanoscenicco.exception.ServiceException
     */
    public Map<String,CatalogoParametro> findParametroBy(String parametro) throws ServiceException;

}
