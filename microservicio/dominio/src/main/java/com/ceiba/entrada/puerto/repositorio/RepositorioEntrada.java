package com.ceiba.entrada.puerto.repositorio;

import com.ceiba.entrada.modelo.entidad.Entrada;

public interface RepositorioEntrada {
    /**
     * Permite crear una entrada
     * @param entrada
     * @return el id generado
     */
    Long crear(Entrada entrada);

    /**
     * Permite eliminar la compra de una entrada
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si la compra la realiza un afiliado dado su tipo y numero de documento para asi aplicar una oferta exclusiva
     * @param tipoDocumento,numeroDocumento
     * @return si existe o no
     */
    boolean ofertaDeAfiliado(String tipoDocumento,String numeroDocumento);

    /**
     * Permite verificar si existe una entrada
     * @param id
     */
    boolean existe(Long id);



}
