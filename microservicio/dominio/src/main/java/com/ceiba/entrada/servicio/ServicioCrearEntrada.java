package com.ceiba.entrada.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.entrada.modelo.entidad.Entrada;
import com.ceiba.entrada.puerto.repositorio.RepositorioEntrada;
import com.ceiba.entrada.utils.MensajesDeExcepcionEntrada;


public class ServicioCrearEntrada {
    private  RepositorioEntrada repositorioEntrada;

    private  ServicioCalcularPrecioEntrada servicioCalcularPrecioEntrada;

    public ServicioCrearEntrada(RepositorioEntrada repositorioEntrada, ServicioCalcularPrecioEntrada servicioCalcularPrecioEntrada) {
        this.repositorioEntrada = repositorioEntrada;
        this.servicioCalcularPrecioEntrada = servicioCalcularPrecioEntrada;
    }


    public Long ejecutar(Entrada entrada) {
        validarEntradaPrevia(entrada);
        entrada.setPrecio(servicioCalcularPrecioEntrada.ejecutar(entrada));
        return this.repositorioEntrada.crear(entrada);
    }

    private void validarEntradaPrevia(Entrada entrada) {
        boolean existe = this.repositorioEntrada.existe(entrada.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(MensajesDeExcepcionEntrada.YA_EXISTE_UNA_ENTRADA_REGISTRADA_CON_ESTE_ID.getMensaje());
        }
    }




}
