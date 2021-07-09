package com.ceiba.entrada.servicio;


import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.entrada.modelo.entidad.Entrada;
import com.ceiba.entrada.puerto.repositorio.RepositorioEntrada;
import com.ceiba.entrada.utils.MensajesDeExcepcionEntrada;

public class ServicioEliminarEntrada {

    private final RepositorioEntrada repositorioEntrada;

    public ServicioEliminarEntrada(RepositorioEntrada repositorioEntrada) {
        this.repositorioEntrada = repositorioEntrada;
    }

    public void ejecutar(Long id){
        this.repositorioEntrada.eliminar(id);
    }


}
