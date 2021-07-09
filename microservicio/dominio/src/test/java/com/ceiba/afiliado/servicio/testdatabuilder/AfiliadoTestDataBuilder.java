package com.ceiba.afiliado.servicio.testdatabuilder;

import com.ceiba.afiliado.modelo.entidad.Afiliado;

import java.time.LocalDateTime;
import java.time.Month;

public class AfiliadoTestDataBuilder {

    private  Long id;
    private  String nombre;
    private  String tipoDocumento;
    private  String numeroDocumento;
    private  LocalDateTime fechaNacimiento;
    private  String email;
    private  String direccion;
    private  String telefono;
    private  LocalDateTime fechaRegistro;

    public AfiliadoTestDataBuilder() {
        id = 1L;
        nombre = "Nicolas";
        tipoDocumento = "cc";
        numeroDocumento = "46541685";
        fechaNacimiento = LocalDateTime.now();
        email = "hola@gmail.com";
        direccion = "casa 3";
        telefono = "3219587525";
        fechaRegistro = LocalDateTime.now().plusDays(4);
    }

    public Afiliado build() {
        return new Afiliado(id,nombre,tipoDocumento,numeroDocumento,fechaNacimiento,email,direccion,telefono,fechaRegistro);
    }
}
