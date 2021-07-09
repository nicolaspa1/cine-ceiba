package com.ceiba.entrada.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoEntrada {
    private Long id;
    private Integer numeroFuncion;
    private Double precio;
    private String nombrePelicula;
    private LocalDateTime fechaFuncion;
}
