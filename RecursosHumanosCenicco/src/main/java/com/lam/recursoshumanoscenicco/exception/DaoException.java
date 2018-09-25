package com.lam.recursoshumanoscenicco.exception;

public class DaoException extends CoreException {

	/**
	 * Default generated serial version.
	 */
	private static final long serialVersionUID = -8509333418998080872L;

	/**
	 * Method to treat the exceptions of the connection layer to the database.
	 * 
	 * @param errorCode
	 *            Error code that is shared with the catalog.
	 * @param message
	 *            Message that will be saved in the trace of the logs.
	 * @param e
	 *            Exception involved.
	 */
	public DaoException(ICodigoError errorCode, String message, Throwable e) {
		super(errorCode, message, e);
	}

}
