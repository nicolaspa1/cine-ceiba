package com.ceiba.entrada.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.afiliado.comando.ComandoAfiliado;
import com.ceiba.afiliado.comando.manejador.ManejadorActualizarAfiliado;
import com.ceiba.afiliado.comando.manejador.ManejadorCrearAfiliado;
import com.ceiba.afiliado.comando.manejador.ManejadorEliminarAfiliado;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/afiliados")
@Api(tags = { "Controlador comando afiliado"})
public class ComandoControladorEntrada {

    private final ManejadorCrearAfiliado manejadorCrearAfiliado;
	private final ManejadorEliminarAfiliado manejadorEliminarAfiliado;
	private final ManejadorActualizarAfiliado manejadorActualizarAfiliado;

    @Autowired
    public ComandoControladorEntrada(ManejadorCrearAfiliado manejadorCrearAfiliado,
									 ManejadorEliminarAfiliado manejadorEliminarAfiliado,
									 ManejadorActualizarAfiliado manejadorActualizarAfiliado) {
        this.manejadorCrearAfiliado = manejadorCrearAfiliado;
		this.manejadorEliminarAfiliado = manejadorEliminarAfiliado;
		this.manejadorActualizarAfiliado = manejadorActualizarAfiliado;
    }

    @PostMapping
    @ApiOperation("Crear Afiliado")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoAfiliado comandoAfiliado) {
        return manejadorCrearAfiliado.ejecutar(comandoAfiliado);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Afiliado")
	public void eliminar(@RequestBody ComandoAfiliado comandoAfiliado, @PathVariable Long id) {
    	comandoAfiliado.setId(id);
		manejadorEliminarAfiliado.ejecutar(comandoAfiliado);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Afiliado")
	public void actualizar(@RequestBody ComandoAfiliado comandoAfiliado,@PathVariable Long id) {
		comandoAfiliado.setId(id);
		manejadorActualizarAfiliado.ejecutar(comandoAfiliado);
	}
}
