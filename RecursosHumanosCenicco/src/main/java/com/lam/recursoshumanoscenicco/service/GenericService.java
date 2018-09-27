package com.lam.recursoshumanoscenicco.service;

import java.util.List;

import com.lam.recursoshumanoscenicco.exception.ServiceException;

/**
 * Interfaz Generica de la capa de servicio que contiene la declaracion de los metodos 
 * basicos de operaciones a la base de datos
 * @author Raul Garcia
 *
 * @param <TYPE>
 * @param <PK>
 */
public interface GenericService<TYPE, PK> {

	/**
	 * Manda a llamar al modelo para guardar un registro en base de datos
	 * @param object
	 * @return Id del registro guardado
	 * @throws ServiceException
	 */
	public PK guardar(TYPE object) throws ServiceException;

	/**
	 * Metodo que se comunica con el la capa de modelo para buscar los registros  de la entidad
	 * enviada en el generic
	 * @return {@link List<TYPE>}
	 * @throws ServiceException
	 */
	List<TYPE> buscarTodo() throws ServiceException;

	/**
	 * Metodo que busca un registro por id
	 * @param id
	 * @return regresa el objecto pasado en la impleentacion del Generic
	 * @throws ServiceException
	 */
	TYPE buscarPorId(PK id) throws ServiceException;

	/**
	 * Metodo que elimina un registro a la base de  datos
	 * @param objectDelete
	 * @throws ServiceException
	 */
	void eliminar(TYPE objectDelete) throws ServiceException;

	/**
	 * 
	 * @param objectUpdate
	 * @throws ServiceException
	 */
	void actualizar(TYPE objectUpdate) throws ServiceException;

	/**
	 * 
	 * @param toSaveOrUpdateType
	 * @throws ServiceException
	 */
	void guardarOActualizar(TYPE toSaveOrUpdateType) throws ServiceException;

	/**
	 * 
	 * @param objecto
	 * @throws ServiceException
	 */
	void buscarPorObjecto(TYPE objecto) throws ServiceException;
}
