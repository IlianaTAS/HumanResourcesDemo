package com.lam.recursoshumanoscenicco.exception;

public enum CodigoErrorEnum implements ICodigoError {

	ERROR_COMUNICACION_BD(100,"Error de conectividad con la base de datos."),
	ERROR_CREAR_BD(102,"Error al crear el registro en la base de datos."),
	ERROR_ACTUALIZAR_BD(103,"Error al modificar el registro en la base de datos."),
	ERROR_ELIMINAR_BD(104,"Error al eliminar el registro en la base de datos."),
	ERROR_CONSULTAR_BD(105,"Error al consultar los registros en la base de datos."),
	ERROR_INTERNO(000,"Error interno de la aplicaci�n");
	

	private int codigo;
	private String mensaje;

	CodigoErrorEnum(int codigo, String mensaje) {
		this.codigo = codigo;
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return name();
	}

	public String errorToString() {
		return mensaje + " [codigo error:" + codigo + "] ";
	}

	
	
}
