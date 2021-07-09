package com.ceiba.afiliado.puerto.dao;

import com.ceiba.afiliado.modelo.dto.DtoAfiliado;

import java.util.List;
import java.util.Optional;

public interface DaoAfiliado {

    /**
     * Permite listar afiliados
     * @return los afiliados
     */
    List<DtoAfiliado> listar();

    Optional<DtoAfiliado> obtenerAfiliadoPorId(Long id);
}
