package com.ceiba.entrada.comando.fabrica;

import com.ceiba.entrada.comando.ComandoEntrada;
import com.ceiba.entrada.modelo.entidad.Entrada;
import org.springframework.stereotype.Component;

@Component
public class FabricaEntrada {
    public Entrada crear(ComandoEntrada comandoEntrada) {
        return new Entrada(
                comandoEntrada.getId(),
                comandoEntrada.getNumeroFuncion(),
                comandoEntrada.getPrecio(),
                comandoEntrada.getNombrePelicula(),
                comandoEntrada.getFechaFuncion()
        );
    }
}
