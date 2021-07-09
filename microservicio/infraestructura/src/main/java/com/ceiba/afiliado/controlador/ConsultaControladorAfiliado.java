package com.ceiba.afiliado.controlador;

import com.ceiba.afiliado.consulta.ManejadorListarAfiliados;
import com.ceiba.afiliado.modelo.dto.DtoAfiliado;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/afiliados")
@Api(tags={"Controlador consulta afiliado"})
public class ConsultaControladorAfiliado {

    private final ManejadorListarAfiliados manejadorListarAfiliados;

    public ConsultaControladorAfiliado(ManejadorListarAfiliados manejadorListarAfiliados) {
        this.manejadorListarAfiliados = manejadorListarAfiliados;
    }


    @GetMapping
    @ApiOperation("Listar Afiliados")
    public List<DtoAfiliado> listar() {
        return this.manejadorListarAfiliados.ejecutar();
    }

}
