package com.ceiba.afiliado.comando.manejador;

import com.ceiba.afiliado.comando.ComandoAfiliado;
import com.ceiba.afiliado.comando.fabrica.FabricaAfiliado;
import com.ceiba.afiliado.modelo.entidad.Afiliado;
import com.ceiba.afiliado.servicio.ServicioActualizarAfiliado;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarAfiliado implements ManejadorComando<ComandoAfiliado> {
    private final FabricaAfiliado fabricaAfiliado;
    private final ServicioActualizarAfiliado servicioActualizarAfiliado;

    public ManejadorActualizarAfiliado(FabricaAfiliado fabricaAfiliado, ServicioActualizarAfiliado servicioActualizarAfiliado) {
        this.fabricaAfiliado = fabricaAfiliado;
        this.servicioActualizarAfiliado = servicioActualizarAfiliado;
    }

    public void ejecutar(ComandoAfiliado comandoAfiliado) {
        Afiliado afiliado = this.fabricaAfiliado.crear(comandoAfiliado);
        this.servicioActualizarAfiliado.ejecutar(afiliado);
    }


}
