package com.ceiba.entrada.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.entrada.comando.ComandoEntrada;
import com.ceiba.entrada.comando.manejador.ManejadorCalcularPrecioEntrada;
import com.ceiba.entrada.comando.manejador.ManejadorCrearEntrada;
import com.ceiba.entrada.comando.manejador.ManejadorEliminarEntrada;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entradas")
@Api(tags = { "Controlador comando entrada"})
public class ComandoControladorEntrada {

    private final ManejadorCrearEntrada manejadorCrearEntrada;
    private final ManejadorEliminarEntrada manejadorEliminarEntrada;
    private final ManejadorCalcularPrecioEntrada manejadorCalcularPrecioEntrada;

	@Autowired
	public ComandoControladorEntrada(ManejadorCrearEntrada manejadorCrearEntrada, ManejadorEliminarEntrada manejadorEliminarEntrada, ManejadorCalcularPrecioEntrada manejadorCalcularPrecioEntrada) {
		this.manejadorCrearEntrada = manejadorCrearEntrada;
		this.manejadorEliminarEntrada = manejadorEliminarEntrada;
		this.manejadorCalcularPrecioEntrada = manejadorCalcularPrecioEntrada;
	}


    @PostMapping
    @ApiOperation("Crear Entrada")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoEntrada comandoEntrada) {
        return manejadorCrearEntrada.ejecutar(comandoEntrada);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Entrada")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarEntrada.ejecutar(id);
	}


	@PostMapping(value="/precio-entrada")
	@ApiOperation("Calcular precio entrada")
	public ComandoRespuesta<Double> calcularPrecio(@RequestBody ComandoEntrada comandoEntrada) {
		return manejadorCalcularPrecioEntrada.ejecutar(comandoEntrada);
	}


}
