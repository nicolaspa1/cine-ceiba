package com.ceiba.entrada.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.afiliado.comando.ComandoAfiliado;
import com.ceiba.afiliado.comando.fabrica.FabricaAfiliado;
import com.ceiba.afiliado.modelo.entidad.Afiliado;
import com.ceiba.entrada.comando.ComandoEntrada;
import com.ceiba.entrada.comando.fabrica.FabricaEntrada;
import com.ceiba.entrada.modelo.entidad.Entrada;
import com.ceiba.entrada.servicio.ServicioCrearEntradaAfiliado;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearEntradaAfiliado {
    private final FabricaEntrada fabricaEntrada;
    private final FabricaAfiliado fabricaAfiliado;
    private final ServicioCrearEntradaAfiliado servicioCrearEntradaAfiliado;

    public ManejadorCrearEntradaAfiliado(FabricaEntrada fabricaEntrada,FabricaAfiliado fabricaAfiliado, ServicioCrearEntradaAfiliado servicioCrearEntradaAfiliado) {
        this.fabricaEntrada = fabricaEntrada;
        this.fabricaAfiliado = fabricaAfiliado;
        this.servicioCrearEntradaAfiliado = servicioCrearEntradaAfiliado;
    }


    public ComandoRespuesta<Long> ejecutar(ComandoEntrada comando, ComandoAfiliado afiliado) {
        Entrada entrada = this.fabricaEntrada.crear(comando);
        Afiliado afiliado1 = this.fabricaAfiliado.crear(afiliado);
        return new ComandoRespuesta<>(this.servicioCrearEntradaAfiliado.ejecutar(entrada,afiliado1));
    }
}
