package com.ceiba.entrada.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoEntrada {
    private final Long id;
    private final Integer numeroFuncion;
    private final Double precio;
    private final String nombrePelicula;
    private final LocalDateTime fechaFuncion;
}
