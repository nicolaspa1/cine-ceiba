package com.ceiba.afiliado.consulta;

import com.ceiba.afiliado.modelo.dto.DtoAfiliado;
import com.ceiba.afiliado.puerto.dao.DaoAfiliado;

import java.util.List;

public class ManejadorListarAfiliados {
    private final DaoAfiliado daoAfiliado;

    public ManejadorListarAfiliados(DaoAfiliado daoAfiliado) {
        this.daoAfiliado = daoAfiliado;
    }

    public List<DtoAfiliado> ejecutar(){
        return this.daoAfiliado.listar();
    }
}
