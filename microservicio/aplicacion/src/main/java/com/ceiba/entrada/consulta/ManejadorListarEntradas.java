package com.ceiba.entrada.consulta;

import com.ceiba.entrada.modelo.dto.DtoEntrada;
import com.ceiba.entrada.puerto.dao.DaoEntrada;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ManejadorListarEntradas {
    private final DaoEntrada daoEntrada;

    public ManejadorListarEntradas(DaoEntrada daoEntrada) {
        this.daoEntrada = daoEntrada;
    }

    public List<DtoEntrada> ejecutar(){
        return this.daoEntrada.listar();
    }
}
