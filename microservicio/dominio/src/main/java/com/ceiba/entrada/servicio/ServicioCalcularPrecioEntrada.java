package com.ceiba.entrada.servicio;

import com.ceiba.entrada.modelo.entidad.Entrada;

public class ServicioCalcularPrecioEntrada {

    private static final double DESCUENTO_LUNES_Y_MARTES_NO_AFILIADO = 0.9;
    private static final double AUMENTO_FIN_DE_SEMANA = 0.25;

    public ServicioCalcularPrecioEntrada() {
    }

    public Double ejecutar(Entrada entrada){
        Double precioEntrada = entrada.getPrecio();

        if (entrada.promoLunesMartes()){
            return precioEntrada*DESCUENTO_LUNES_Y_MARTES_NO_AFILIADO;
        }else if (entrada.promoFinDeSemana()){
            return precioEntrada + (precioEntrada*AUMENTO_FIN_DE_SEMANA);
        }
        return precioEntrada;
    }
}
