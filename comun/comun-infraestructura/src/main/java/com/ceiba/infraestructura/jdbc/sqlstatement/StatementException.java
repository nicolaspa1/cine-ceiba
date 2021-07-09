package com.ceiba.infraestructura.jdbc.sqlstatement;

public class StatementException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StatementException(String message) {
        super(message);
    }
}
