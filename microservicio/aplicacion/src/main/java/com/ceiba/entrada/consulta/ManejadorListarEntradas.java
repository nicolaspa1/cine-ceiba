package com.ceiba.entrada.consulta;

import com.ceiba.afiliado.modelo.dto.DtoAfiliado;
import com.ceiba.afiliado.puerto.dao.DaoAfiliado;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ManejadorListarEntradas {
    private final DaoAfiliado daoAfiliado;

    public ManejadorListarEntradas(DaoAfiliado daoAfiliado) {
        this.daoAfiliado = daoAfiliado;
    }

    public List<DtoAfiliado> ejecutar(){
        return this.daoAfiliado.listar();
    }
}
