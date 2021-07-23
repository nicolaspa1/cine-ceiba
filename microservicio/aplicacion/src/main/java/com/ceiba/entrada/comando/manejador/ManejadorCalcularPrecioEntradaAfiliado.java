package com.ceiba.entrada.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.afiliado.comando.ComandoAfiliado;
import com.ceiba.afiliado.comando.fabrica.FabricaAfiliado;
import com.ceiba.afiliado.modelo.entidad.Afiliado;
import com.ceiba.entrada.comando.ComandoEntrada;
import com.ceiba.entrada.comando.fabrica.FabricaEntrada;
import com.ceiba.entrada.modelo.entidad.Entrada;
import com.ceiba.entrada.servicio.ServicioCalcularPrecioEntradaAfiliado;
import org.springframework.stereotype.Component;

@Component

public class ManejadorCalcularPrecioEntradaAfiliado {

    private final FabricaEntrada fabricaEntrada;
    private final FabricaAfiliado fabricaAfiliado;
    private final ServicioCalcularPrecioEntradaAfiliado servicioCalcularPrecioEntradaAfiliado;

    public ManejadorCalcularPrecioEntradaAfiliado(FabricaEntrada fabricaEntrada,FabricaAfiliado fabricaAfiliado, ServicioCalcularPrecioEntradaAfiliado servicioCalcularPrecioEntradaAfiliado) {
        this.fabricaEntrada = fabricaEntrada;
        this.fabricaAfiliado = fabricaAfiliado;
        this.servicioCalcularPrecioEntradaAfiliado = servicioCalcularPrecioEntradaAfiliado;
    }


    public ComandoRespuesta<Double> ejecutar(ComandoEntrada comando, ComandoAfiliado afiliado) {
        Entrada entrada = this.fabricaEntrada.crear(comando);
        Afiliado afiliado1 = this.fabricaAfiliado.crear(afiliado);
        return new ComandoRespuesta<>(servicioCalcularPrecioEntradaAfiliado.ejecutar(entrada,afiliado1));
    }
}
