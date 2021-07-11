package com.ceiba.afiliado.testdatabuilder;

import com.ceiba.afiliado.comando.ComandoAfiliado;

import java.time.LocalDateTime;

public class ComandoAfiliadoTestDataBuilder {
    private Long id;
    private  String nombre;
    private  String tipoDocumento;
    private  String numeroDocumento;
    private  LocalDateTime fechaNacimiento;
    private  String email;
    private  String direccion;
    private  String telefono;
    private  LocalDateTime fechaRegistro;
    public ComandoAfiliadoTestDataBuilder() {
        nombre = "Nicolas";
        tipoDocumento = "cc";
        numeroDocumento = "46541685";
        fechaNacimiento = LocalDateTime.now();
        email = "hola@gmail.com";
        direccion = "casa 3";
        telefono = "3219587525";
        fechaRegistro = LocalDateTime.now().plusDays(4);
    }

    public ComandoAfiliado build() {
        return new ComandoAfiliado(id,nombre,tipoDocumento,numeroDocumento,fechaNacimiento,email,direccion,telefono,fechaRegistro);
    }
}
