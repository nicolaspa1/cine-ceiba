package com.ceiba.afiliado.controlador;

import com.ceiba.afiliado.comando.manejador.ManejadorBuscarAfiliado;
import com.ceiba.afiliado.consulta.ManejadorListarAfiliados;
import com.ceiba.afiliado.modelo.dto.DtoAfiliado;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/afiliados")
@Api(tags={"Controlador consulta afiliado"})
public class ConsultaControladorAfiliado {

    private final ManejadorListarAfiliados manejadorListarAfiliados;
    private final ManejadorBuscarAfiliado manejadorBuscarAfiliado;


    public ConsultaControladorAfiliado(ManejadorListarAfiliados manejadorListarAfiliados, ManejadorBuscarAfiliado manejadorBuscarAfiliado) {
        this.manejadorListarAfiliados = manejadorListarAfiliados;
        this.manejadorBuscarAfiliado = manejadorBuscarAfiliado;
    }


    @GetMapping
    @ApiOperation("Listar Afiliados")
    public List<DtoAfiliado> listar() {
        return this.manejadorListarAfiliados.ejecutar();
    }

    @GetMapping(value="/{id}")
    @ApiOperation("Buscar Afiliados")
    public DtoAfiliado buscarPorId(@PathVariable Long id) {
        return this.manejadorBuscarAfiliado.ejecutar(id);
    }

}
