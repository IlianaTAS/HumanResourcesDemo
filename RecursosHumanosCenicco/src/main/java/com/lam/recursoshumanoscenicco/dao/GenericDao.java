package com.lam.recursoshumanoscenicco.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface GenericDao<TYPE extends Serializable, PK extends Serializable> extends Serializable {

    
    /**
     * Se encarga de crear un registro en la base de datos.
     * @param toCreate Entity con los datos de l registro que se va a dar de alta.
     * @return Llave Primaria del registro a dar de alta.
     */
    PK save(TYPE toCreate);

    /**
     * Se encarga de eliminar el registro al que referencia el {@code entity}.
     * @param toDelete Entity con la llave primaria que se va a eliminar.
     */
    void delete(TYPE toDelete);

    /**
     * Se encarga de actualizar una registro en la base de datos, el {@code entity}
     * que se pasa por referencia no debe haber cambiado su {@code primary key}. Si
     * se desea cambiar el {@code primary key} se deber&aacute; ocupar un {@code namedQuery}.
     * @param toUpdate Entity que se va a actualizar.
     */
    void update(TYPE toUpdate);

    /**
     * Se encarga de actualizar una registro en la base de datos, el {@code entity}
     * que se pasa por referencia no debe haber cambiado su {@code primary key}. Si
     * se desea cambiar el {@code primary key} se deber&aacute; ocupar un {@code namedQuery}.
     * @param toUpdate Entity que se va a actualizar.
     */
    void merge(TYPE toUpdate);

    /**
     * Se encarga de buscar los datos completos de un registro en la tabla, se debe
     * pasar por referencia una instancia de la clase de la llave primaria de la
     * tabla.
     * @param primaryKey Llave primari de la tabla.
     * @return Entity con los datos del registro en la tabla, {@code null} en otro
     * caso.
     */
    TYPE find(PK primaryKey); 

    /**
     * Se encarga de buscar los datos completos de un registro en la tabla, se debe
     * pasar por referencia una instancia de la clase de la llave primaria de la
     * tabla.
     * @param example Datos de ejemplo para los entities que cumplan con ese criterio.
     * @return Entity con los datos del registro en la tabla, {@code null} en otro
     * caso.
     */
    List<TYPE> findByExample(TYPE example);    

    /**
     * Se encarga de hacer una busqueda por los campos diferentes de {@code null}
     * dentro de la tabla a la que est&aacute; mapeado el {@code entity}.
     * @return Lista de datos con los {@code entities} encontrados.
     */
    List<TYPE> findAll();
    
    /**
     * Se encarga de Crear o Actualizar un registro en la base de datos.
     * @param toSaveOrUpdateType Entity que se va a crear o actualizar.
     */
    void saveOrUpdate(TYPE toSaveOrUpdateType);
}
