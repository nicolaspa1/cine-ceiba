package com.ceiba.entrada.servicio;


import com.ceiba.entrada.puerto.repositorio.RepositorioEntrada;

public class ServicioEliminarEntrada {

    private final RepositorioEntrada repositorioEntrada;

    public ServicioEliminarEntrada(RepositorioEntrada repositorioEntrada) {
        this.repositorioEntrada = repositorioEntrada;
    }

    public void ejecutar(Long id){
        this.repositorioEntrada.eliminar(id);
    }


}
