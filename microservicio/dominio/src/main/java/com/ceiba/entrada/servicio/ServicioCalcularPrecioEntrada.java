package com.ceiba.entrada.servicio;

import com.ceiba.afiliado.modelo.entidad.Afiliado;
import com.ceiba.afiliado.utils.MensajesDeExcepcion;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.entrada.modelo.entidad.Entrada;
import com.ceiba.entrada.puerto.repositorio.RepositorioEntrada;

import java.time.LocalDate;

public class ServicioCalcularPrecioEntrada {

    private static final double DESCUENTO_LUNES_Y_MARTES_AFILIADO = 0.5;
    private static final double DESCUENTO_LUNES_Y_MARTES_NO_AFILIADO = 0.1;
    private static final double DESCUENTO_MIERCOLES_JUEVES_AFILIADO = 0.5;
    private static final double DESCUENTO_VIERNES_AFILIADO = 0.3;

    private static final double AUMENTO_FIN_DE_SEMANA = 0.25;

    private final RepositorioEntrada repositorioEntrada;

    public ServicioCalcularPrecioEntrada(RepositorioEntrada repositorioEntrada) {
        this.repositorioEntrada = repositorioEntrada;
    }

    public Double ejecutar(Entrada entrada, Afiliado afiliado){
        Boolean hayDescuento = this.repositorioEntrada.ofertaDeAfiliado(afiliado.getTipoDocumento(), afiliado.getNumeroDocumento());
        Double precioEntrada = entrada.getPrecio();
        if (entrada.promoLunesMartes()&&hayDescuento){
            return precioEntrada*DESCUENTO_LUNES_Y_MARTES_AFILIADO;
        }
        if (entrada.promoMiercolesJueves()&&hayDescuento){
            return precioEntrada*DESCUENTO_MIERCOLES_JUEVES_AFILIADO;
        }
        if (entrada.promoViernes()&&hayDescuento){
            return precioEntrada*DESCUENTO_VIERNES_AFILIADO;
        }
        return precioEntrada;
    }

    public Double ejecutar(Entrada entrada){
        Double precioEntrada = entrada.getPrecio();
        if (entrada.promoLunesMartes()){
            return precioEntrada*DESCUENTO_LUNES_Y_MARTES_NO_AFILIADO;
        }
        if (entrada.promoFinDeSemana()){
            return precioEntrada + (precioEntrada*AUMENTO_FIN_DE_SEMANA);
        }
        return precioEntrada;
    }
}
