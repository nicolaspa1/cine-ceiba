package com.ceiba.afiliado.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoAfiliado {
    private final Long id;
    private final String nombre;
    private final String tipoDocumento;
    private final String numeroDocumento;
    private final LocalDateTime fechaNacimiento;
    private final String email;
    private final String direccion;
    private final String telefono;
    private final LocalDateTime fechaRegistro;
}
