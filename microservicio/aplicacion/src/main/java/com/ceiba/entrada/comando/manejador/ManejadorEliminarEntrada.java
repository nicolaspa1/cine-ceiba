package com.ceiba.entrada.comando.manejador;

import com.ceiba.afiliado.servicio.ServicioEliminarAfiliado;
import com.ceiba.entrada.comando.ComandoEntrada;
import com.ceiba.entrada.servicio.ServicioEliminarEntrada;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarEntrada implements ManejadorComando<Long> {
    private final ServicioEliminarEntrada servicioEliminarEntrada;

    public ManejadorEliminarEntrada(ServicioEliminarEntrada servicioEliminarEntrada) {
        this.servicioEliminarEntrada = servicioEliminarEntrada;
    }

    @Override
    public void ejecutar(Long id ) {
        this.servicioEliminarEntrada.ejecutar(id);
    }
}
