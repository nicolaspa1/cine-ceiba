package com.ceiba.infraestructura.actuator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import com.ceiba.infraestructura.error.ErrorHealthCheck;

@Configuration
public class ManejadorHealthCheckBloques {

	private Map<String, Salud> bloquesRegistrados = new HashMap<>();
	private List<ErrorHealthCheck> listadoErroresBloques = new ArrayList<>();
	private static final Logger LOGGER_ERROR = LoggerFactory.getLogger(ManejadorHealthCheckBloques.class);
	private static final String MENSAJE_ERROR_EN_BLOQUE = "Error de conexion con el bloque ";

	public void registrarme(String nombreBloque, Salud salud) {
		this.bloquesRegistrados.put(nombreBloque, salud);
	}

	@Scheduled(fixedRateString = "${tiempoHealthCheck.tiempo}")
	public void refrescarListadoErrores() {
		this.bloquesRegistrados.forEach((llave, valor) -> validarBloque(llave, this.bloquesRegistrados.get(llave)));

	}

	private void validarBloque(String key, Salud salud) {
		try {
			salud.verificar();
			this.listadoErroresBloques = new ArrayList<>();
		} catch (RuntimeException e) {
			LOGGER_ERROR.error(MENSAJE_ERROR_EN_BLOQUE + key);
			this.listadoErroresBloques = new ArrayList<>();
			this.listadoErroresBloques.add(new ErrorHealthCheck(key));
		}
	}

	public boolean existenErrores() {
		return !listadoErroresBloques.isEmpty();
	}

	public List<ErrorHealthCheck> getListadoErroresBloques() {
		return listadoErroresBloques;
	}

}
