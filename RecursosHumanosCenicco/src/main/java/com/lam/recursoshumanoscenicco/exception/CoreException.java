package com.lam.recursoshumanoscenicco.exception;

public class CoreException extends Exception {

	/**
	 * Default generated serial version.
	 */
	private static final long serialVersionUID = 2051229118513207851L;

	private ICodigoError errorCodigo;

	private String mensaje;

	/**
	 * Constructor for the core of exceptions.
	 * 
	 * @param errorCodigo
	 *            Code that is shared with the message catalog according to the
	 *            exception.
	 * @param mensaje
	 *            Information about the error that is being treated.
	 * @param e
	 *            Exception.
	 */
	public CoreException(ICodigoError errorCodigo, String mensaje, Throwable e) {
		super(mensaje, e);
		this.errorCodigo = errorCodigo;
		this.mensaje = mensaje;
	}

	/**
	 * Constructor for the core of exceptions.
	 * 
	 * @param errorCodigo
	 *            Code that is shared with the message catalog according to the
	 *            exception.
	 * @param mensaje
	 *            Information about the error that is being treated.
	 */
	public CoreException(ICodigoError errorCodigo, String mensaje) {
		super(mensaje);
		this.errorCodigo = errorCodigo;
	}

	/**
	 * Constructor for the core of exceptions.
	 * 
	 * @param mensaje
	 *            Information about the error that is being treated.
	 * @param e
	 *            Exception.
	 */
	public CoreException(String mensaje, Throwable e) {
		super(mensaje, e);
		this.mensaje = mensaje;
	}

	/**
	 * Constructor for the core of exceptions.
	 * 
	 * @param mensaje
	 *            Information about the error that is being treated.
	 */
	public CoreException(String mensaje) {
		super(mensaje);
		this.mensaje = mensaje;
	}

	@Override
	public String getMessage() {
		if (errorCodigo != null) {
			return errorCodigo.errorToString() + super.getMessage();
		} else {
			return super.getMessage();
		}
	}

	public String getMensaje() {
		return this.mensaje;
	}

	/**
	 * Return the message to locate the error that occurs
	 * 
	 * @return error trace.
	 */
	public String getTraceLog() {
		return errorCodigo.errorToString() + "\n" + super.getMessage();
	}

	/**
	 * @return the errorCode
	 */
	public ICodigoError getErrorCodigo() {
		return errorCodigo;
	}

}
