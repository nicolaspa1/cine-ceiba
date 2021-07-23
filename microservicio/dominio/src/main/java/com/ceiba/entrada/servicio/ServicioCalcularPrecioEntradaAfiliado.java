package com.ceiba.entrada.servicio;

import com.ceiba.afiliado.modelo.entidad.Afiliado;
import com.ceiba.entrada.modelo.entidad.Entrada;
import com.ceiba.entrada.puerto.repositorio.RepositorioEntrada;

public class ServicioCalcularPrecioEntradaAfiliado {

    private static final double DESCUENTO_LUNES_Y_MARTES_AFILIADO = 0.5;
    private static final double DESCUENTO_MIERCOLES_JUEVES_AFILIADO = 0.5;
    private static final double DESCUENTO_VIERNES_AFILIADO = 0.7;

    private final RepositorioEntrada repositorioEntrada;


    public ServicioCalcularPrecioEntradaAfiliado(RepositorioEntrada repositorioEntrada) {
        this.repositorioEntrada = repositorioEntrada;
    }

    public Double ejecutar(Entrada entrada, Afiliado afiliado){
        boolean hayDescuento = this.repositorioEntrada.ofertaDeAfiliado(afiliado.getTipoDocumento(), afiliado.getNumeroDocumento());
        Double precioEntrada = entrada.getPrecio();
        if (entrada.promoLunesMartes()&&hayDescuento){
            return precioEntrada*DESCUENTO_LUNES_Y_MARTES_AFILIADO;
        } else if (entrada.promoMiercolesJueves()&&hayDescuento){
            return precioEntrada*DESCUENTO_MIERCOLES_JUEVES_AFILIADO;
        } else if (entrada.promoViernes()&&hayDescuento){
            return precioEntrada*DESCUENTO_VIERNES_AFILIADO;
        }
        return precioEntrada;
    }
}
