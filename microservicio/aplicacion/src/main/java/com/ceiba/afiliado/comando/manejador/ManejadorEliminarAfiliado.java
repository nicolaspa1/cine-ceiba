package com.ceiba.afiliado.comando.manejador;

import com.ceiba.afiliado.comando.ComandoAfiliado;
import com.ceiba.afiliado.servicio.ServicioEliminarAfiliado;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarAfiliado implements ManejadorComando<ComandoAfiliado> {
    private final ServicioEliminarAfiliado servicioEliminarAfiliado;

    public ManejadorEliminarAfiliado(ServicioEliminarAfiliado servicioEliminarAfiliado) {
        this.servicioEliminarAfiliado = servicioEliminarAfiliado;
    }


    @Override
    public void ejecutar(ComandoAfiliado comando) {
    this.servicioEliminarAfiliado.ejecutar(comando.getId());
    }
}
