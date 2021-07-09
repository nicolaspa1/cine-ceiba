package com.ceiba.afiliado.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.afiliado.comando.ComandoAfiliado;
import com.ceiba.afiliado.comando.fabrica.FabricaAfiliado;
import com.ceiba.afiliado.modelo.entidad.Afiliado;
import com.ceiba.afiliado.servicio.ServicioCrearAfiliado;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearAfiliado implements ManejadorComandoRespuesta<ComandoAfiliado, ComandoRespuesta<Long>> {
    private final FabricaAfiliado fabricaAfiliado;
    private final ServicioCrearAfiliado servicioCrearAfiliado;

    public ManejadorCrearAfiliado(FabricaAfiliado fabricaAfiliado, ServicioCrearAfiliado servicioCrearAfiliado) {
        this.fabricaAfiliado = fabricaAfiliado;
        this.servicioCrearAfiliado = servicioCrearAfiliado;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoAfiliado comando) {
        Afiliado afiliado = this.fabricaAfiliado.crear(comando);
        return new ComandoRespuesta<>(this.servicioCrearAfiliado.ejecutar(afiliado));
    }
}
