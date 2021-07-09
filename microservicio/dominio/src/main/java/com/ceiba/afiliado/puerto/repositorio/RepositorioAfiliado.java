package com.ceiba.afiliado.puerto.repositorio;

import com.ceiba.afiliado.modelo.entidad.Afiliado;

public interface RepositorioAfiliado {
    /**
     * Permite crear un afiliado
     * @param afiliado
     * @return el id generado
     */
    Long crear(Afiliado afiliado);

    /**
     * Permite actualizar un afiliado
     * @param afiliado
     */
    void actualizar(Afiliado afiliado);

    /**
     * Permite eliminar un afiliado
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un afiliado dado su tipo y numero de documento
     * @param tipoDocumento,numeroDocumento
     * @return si existe o no
     */
    boolean existe(String tipoDocumento,String numeroDocumento);



}
