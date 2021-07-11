package com.ceiba.afiliado.comando.manejador;

import com.ceiba.afiliado.servicio.ServicioEliminarAfiliado;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarAfiliado implements ManejadorComando<Long> {
    private final ServicioEliminarAfiliado servicioEliminarAfiliado;

    public ManejadorEliminarAfiliado(ServicioEliminarAfiliado servicioEliminarAfiliado) {
        this.servicioEliminarAfiliado = servicioEliminarAfiliado;
    }


    @Override
    public void ejecutar(Long id) {
    this.servicioEliminarAfiliado.ejecutar(id);
    }
}
