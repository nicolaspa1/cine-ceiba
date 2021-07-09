package com.ceiba.infraestructura.error;


public class ErrorHealthCheck {
	
	private String nombre;
	private String estado;

	
	
	public ErrorHealthCheck(String nombre) {
		this.nombre = nombre;
		this.estado = "DOWN";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	

}
