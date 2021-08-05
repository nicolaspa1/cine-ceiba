package com.ceiba.entrada.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.afiliado.comando.ComandoAfiliado;
import com.ceiba.entrada.comando.ComandoEntrada;
import com.ceiba.entrada.comando.manejador.ManejadorCalcularPrecioEntradaAfiliado;
import com.ceiba.entrada.comando.manejador.ManejadorCrearEntradaAfiliado;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entradasA")
@Api(tags = { "Controlador comando entrada afiliado"})
public class ComandoControladorEntradaAfiliado {

    private final ManejadorCrearEntradaAfiliado manejadorCrearEntradaAfiliado;
    private final ManejadorCalcularPrecioEntradaAfiliado manejadorCalcularPrecioEntradaAfiliado;

    @Autowired
    public ComandoControladorEntradaAfiliado(ManejadorCrearEntradaAfiliado manejadorCrearEntradaAfiliado , ManejadorCalcularPrecioEntradaAfiliado manejadorCalcularPrecioEntradaAfiliado) {
        this.manejadorCrearEntradaAfiliado = manejadorCrearEntradaAfiliado;
        this.manejadorCalcularPrecioEntradaAfiliado = manejadorCalcularPrecioEntradaAfiliado;
    }


    @PostMapping
    @ApiOperation("Crear Entrada Afiliado")
    public ComandoRespuesta<Long> crearEntradaAfiliado(@RequestBody ComandoEntrada comandoEntrada,@RequestBody ComandoAfiliado comandoAfiliado) {
        return manejadorCrearEntradaAfiliado.ejecutar(comandoEntrada,comandoAfiliado);
    }

}
