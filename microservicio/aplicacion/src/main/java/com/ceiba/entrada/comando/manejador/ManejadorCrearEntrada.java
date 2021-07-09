package com.ceiba.entrada.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.afiliado.comando.fabrica.FabricaAfiliado;
import com.ceiba.afiliado.modelo.entidad.Afiliado;
import com.ceiba.entrada.comando.ComandoEntrada;
import com.ceiba.entrada.comando.fabrica.FabricaEntrada;
import com.ceiba.entrada.modelo.entidad.Entrada;
import com.ceiba.entrada.servicio.ServicioCrearEntrada;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearEntrada implements ManejadorComandoRespuesta<ComandoEntrada, ComandoRespuesta<Long>> {
    private final FabricaEntrada fabricaEntrada;
    private final FabricaAfiliado fabricaAfiliado;

    private final ServicioCrearEntrada servicioCrearEntrada;

    public ManejadorCrearEntrada(FabricaEntrada fabricaEntrada, FabricaAfiliado fabricaAfiliado, ServicioCrearEntrada servicioCrearEntrada) {
        this.fabricaEntrada = fabricaEntrada;
        this.fabricaAfiliado = fabricaAfiliado;
        this.servicioCrearEntrada = servicioCrearEntrada;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoEntrada comando) {
        Entrada entrada = this.fabricaEntrada.crear(comando);
        return new ComandoRespuesta<>(this.servicioCrearEntrada.ejecutar(entrada));
    }
    public ComandoRespuesta<Long> ejecutar(ComandoEntrada comando,Afiliado afiliado) {
        Entrada entrada = this.fabricaEntrada.crear(comando);
        return new ComandoRespuesta<>(this.servicioCrearEntrada.ejecutar(entrada,afiliado));
    }
}
