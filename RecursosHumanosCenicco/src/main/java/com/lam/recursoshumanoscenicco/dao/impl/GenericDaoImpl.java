package com.lam.recursoshumanoscenicco.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.lam.recursoshumanoscenicco.dao.GenericDao;

public class GenericDaoImpl<TYPE extends Serializable, PK extends Serializable> extends HibernateDaoSupport implements GenericDao<TYPE, PK> {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4231518077126152616L; 
	
	/*
     * Clase concreta que se esta utilizando en el generic.
     */
    private Class<TYPE> persistenceClass;


    /**
     * Regresa la clase que se est&aacute; envolviendo con esta instancia.
     * 
     * @return Clase con la que se est&aacute; envolviendo a esta instancia.
     */
    @SuppressWarnings("unchecked")
    public Class<TYPE> getPersistenceClass() {
        if (persistenceClass == null) {
            Class<?> clazz = getClass();

            while (!(clazz.getGenericSuperclass() instanceof ParameterizedType)) {
                clazz = clazz.getSuperclass();
            }
            persistenceClass = (Class<TYPE>) ((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return persistenceClass;
    }

    /*
     * Se encarga de crear un registro en la base de datos.
     * 
     * @param toCreate Entity con los datos de l registro que se va a dar de
     * alta.
     * 
     * @return Llave Primaria del registro a dar de alta.
     */    
    @SuppressWarnings("unchecked")
	public PK save(TYPE toCreate) {
        PK id = null;
        id = (PK) this.getHibernateTemplate().save(toCreate);
        this.getHibernateTemplate().flush();
        return id;
    };

    /*
     * Se encarga de actualizar una registro en la base de datos, el {@code
     * entity} que se pasa por referencia no debe haber cambiado su {@code
     * primary key}. Si se desea cambiar el {@code primary key} se deber&aacute;
     * ocupar un {@code namedQuery}.
     */
    public void update(TYPE transientObject) {
        this.getHibernateTemplate().update(transientObject);
    }

    /*
     * Se encarga de actualizar una registro en la base de datos, el {@code
     * entity} que se pasa por referencia no debe haber cambiado su {@code
     * primary key}. Si se desea cambiar el {@code primary key} se deber&aacute;
     * ocupar un {@code namedQuery}.
     */
    public void merge(TYPE transientObject) {
        this.getHibernateTemplate().merge(transientObject);
    }

    /*
     * Se encarga de eliminar el registro al que referencia el {@code entity}.
     * 
     * @param toDelete Entity con la llave primaria que se va a eliminar.
     */
    public void delete(TYPE toDelete) {
        this.getHibernateTemplate().delete(toDelete);
        this.getHibernateTemplate().flush();
    }

    /*
     * Se encarga de hacer una busqueda por los campos diferentes de {@code
     * null} dentro de la tabla a la que est&aacute; mapeado el {@code entity}.
     * 
     * @return Lista de datos con los {@code entities} encontrados.
     */
    public List<TYPE> findAll() {
        return this.getHibernateTemplate().loadAll(getPersistenceClass());
    }

    /*
     * Se encarga de buscar los datos completos de un registro en la tabla, se
     * debe pasar por referencia una instancia de la clase de la llave primaria
     * de la tabla.
     * 
     * @param primaryKey Llave primari de la tabla.
     * 
     * @return Entity con los datos del registro en la tabla, {@code null} en
     * otro caso.
     */
    public TYPE find(PK primaryKey) {
        return (TYPE) this.getHibernateTemplate().get(getPersistenceClass(), primaryKey);
    }

    /*
     * Se encarga de buscar los datos completos de un registro en la tabla, se
     * debe pasar por referencia una instancia de la clase de la llave primaria
     * de la tabla.
     * 
     * @param example Datos de ejemplo para los entities que cumplan con ese
     * criterio.
     * 
     * @return Entity con los datos del registro en la tabla, {@code null} en
     * otro caso.
     */
    
    public List<TYPE> findByExample(TYPE example) {
        return (List<TYPE>) this.getHibernateTemplate().findByExample(example);
    }
    
    /*
     * Se encarga de Crear o Actualizar un registro en la base de datos. 
     * 
     * @param toSaveOrUpdateType Entity que se va a crear o actualizar.
     */
    public void saveOrUpdate(TYPE toSaveOrUpdateType){
    	this.getHibernateTemplate().saveOrUpdate(toSaveOrUpdateType);
    }
}
