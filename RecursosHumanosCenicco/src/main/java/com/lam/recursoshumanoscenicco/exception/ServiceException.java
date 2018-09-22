package com.lam.recursoshumanoscenicco.exception;

public class ServiceException extends CoreException {

	/**
	 * Default generated serial version.
	 */
	private static final long serialVersionUID = 582933028642268923L;

	/**
	 * Method that treats exceptions at the service level in the project.
	 * 
	 * @param errorCode
	 *            Error code that is shared with the catalog.
	 * @param message
	 *            Message that will be saved in the trace of the logs.
	 * @param e
	 *            Exception involved.
	 */
	public ServiceException(ICodigoError errorCode, String message, Throwable e) {
		super(errorCode, message, e);
	}

}
