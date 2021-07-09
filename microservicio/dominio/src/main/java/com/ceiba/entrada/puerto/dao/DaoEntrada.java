package com.ceiba.entrada.puerto.dao;

import com.ceiba.entrada.modelo.dto.DtoEntrada;

import java.util.List;

public interface DaoEntrada {

    /**
     * Permite listar funciones
     * @return las funciones
     */
    List<DtoEntrada> listar();
}
