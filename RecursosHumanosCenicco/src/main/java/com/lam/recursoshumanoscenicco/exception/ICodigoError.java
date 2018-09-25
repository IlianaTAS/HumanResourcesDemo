package com.lam.recursoshumanoscenicco.exception;

public interface ICodigoError {

	/**
	 * Method to returns the message.
	 * 
	 * @return
	 */
	public String getMensaje();

	/**
	 * Method that returns the canonical name of the enumeration.
	 * 
	 * @return
	 */
	public String getNombre();

	/**
	 * Method that returns the code.
	 * 
	 * @return
	 */
	public int getCodigo();

	/**
	 * Method to convert the error to String.
	 * 
	 * @return
	 */
	public String errorToString();

}
