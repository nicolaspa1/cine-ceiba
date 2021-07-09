package com.ceiba.entrada.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.afiliado.modelo.entidad.Afiliado;
import com.ceiba.entrada.comando.ComandoEntrada;
import com.ceiba.entrada.comando.fabrica.FabricaEntrada;
import com.ceiba.entrada.modelo.entidad.Entrada;
import com.ceiba.entrada.servicio.ServicioCalcularPrecioEntrada;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component

public class ManejadorCalcularPrecioEntrada implements ManejadorComandoRespuesta<ComandoEntrada, ComandoRespuesta<Double>> {

    private final FabricaEntrada fabricaEntrada;
    private final ServicioCalcularPrecioEntrada servicioCalcularPrecioEntrada;

    public ManejadorCalcularPrecioEntrada(FabricaEntrada fabricaEntrada, ServicioCalcularPrecioEntrada servicioCalcularPrecioEntrada) {
        this.fabricaEntrada = fabricaEntrada;
        this.servicioCalcularPrecioEntrada = servicioCalcularPrecioEntrada;
    }

    @Override
    public ComandoRespuesta<Double> ejecutar(ComandoEntrada comando) {
        Entrada entrada = this.fabricaEntrada.crear(comando);
        return new ComandoRespuesta<>(servicioCalcularPrecioEntrada.ejecutar(entrada));
    }

    public ComandoRespuesta<Double> ejecutar(ComandoEntrada comando, Afiliado afiliado) {
        Entrada entrada = this.fabricaEntrada.crear(comando);
        return new ComandoRespuesta<>(servicioCalcularPrecioEntrada.ejecutar(entrada,afiliado));
    }
}
