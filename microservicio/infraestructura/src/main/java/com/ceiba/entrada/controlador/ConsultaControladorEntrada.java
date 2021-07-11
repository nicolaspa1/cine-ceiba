package com.ceiba.entrada.controlador;

import com.ceiba.afiliado.modelo.dto.DtoAfiliado;
import com.ceiba.entrada.consulta.ManejadorListarEntradas;
import com.ceiba.entrada.modelo.dto.DtoEntrada;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entradas")
@Api(tags={"Controlador consulta entradas"})
public class ConsultaControladorEntrada {

    private final ManejadorListarEntradas manejadorListarEntradas;

    public ConsultaControladorEntrada(ManejadorListarEntradas manejadorListarEntradas) {
        this.manejadorListarEntradas = manejadorListarEntradas;
    }


    @GetMapping
    @ApiOperation("Listar Entradas")
    public List<DtoEntrada> listar() {
        return this.manejadorListarEntradas.ejecutar();
    }

}
