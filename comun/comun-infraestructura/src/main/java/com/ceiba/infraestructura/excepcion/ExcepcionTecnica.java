package com.ceiba.infraestructura.excepcion;

public class ExcepcionTecnica extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionTecnica(String message) {
        super(message);
    }
	
	public ExcepcionTecnica(String message, Exception e) {
		super(message,e);
	}
}
