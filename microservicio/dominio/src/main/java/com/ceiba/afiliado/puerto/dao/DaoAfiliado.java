package com.ceiba.afiliado.puerto.dao;

import com.ceiba.afiliado.modelo.dto.DtoAfiliado;

import java.util.List;

public interface DaoAfiliado {

    /**
     * Permite listar afiliados
     * @return los afiliados
     */
    List<DtoAfiliado> listar();

    DtoAfiliado obtenerAfiliadoPorId(Long id);
}
