package com.ceiba.entrada.servicio.testdatabuilder;

import com.ceiba.entrada.comando.ComandoUsuario;

import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoUsuarioTestDataBuilder {

    private Long id;
    private String nombre;
    private String clave;
    private LocalDateTime fecha;

    public ComandoUsuarioTestDataBuilder() {
        nombre = UUID.randomUUID().toString();
        clave = "1234";
        fecha = LocalDateTime.now();
    }

    public ComandoUsuarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoUsuario build() {
        return new ComandoUsuario(id,nombre, clave,fecha);
    }
}
