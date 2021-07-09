package com.ceiba.afiliado.servicio;

import com.ceiba.afiliado.puerto.repositorio.RepositorioAfiliado;

public class ServicioEliminarAfiliado {

    private final RepositorioAfiliado repositorioAfiliado;

    public ServicioEliminarAfiliado(RepositorioAfiliado repositorioAfiliado) {
        this.repositorioAfiliado = repositorioAfiliado;
    }

    public void ejecutar(Long id){
        this.repositorioAfiliado.eliminar(id);
    }

}
