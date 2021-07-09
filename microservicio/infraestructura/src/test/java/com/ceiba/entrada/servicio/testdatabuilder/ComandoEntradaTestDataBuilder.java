package com.ceiba.entrada.servicio.testdatabuilder;

import com.ceiba.entrada.comando.ComandoEntrada;

import java.time.LocalDateTime;
import java.time.Month;

public class ComandoEntradaTestDataBuilder {

    private   Long id;
    private   Integer numeroFuncion;
    private   Double precio;
    private   String nombrePelicula;
    private   LocalDateTime fechaFuncion;

    public ComandoEntradaTestDataBuilder() {
        this.id = 2L;
        this.numeroFuncion = 2;
        this.precio = 10000.0;
        this.nombrePelicula = "Tron";
        this.fechaFuncion = LocalDateTime.now().plusDays(4);
    }
    public ComandoEntradaTestDataBuilder fechaFuncionFinDeSemana() {
        this.fechaFuncion = LocalDateTime.of(2021, Month.JULY, 10, 18, 00);
        return this;
    }
    public ComandoEntradaTestDataBuilder fechaFuncionLunesMartes() {
        this.fechaFuncion = LocalDateTime.of(2021, Month.JULY, 13, 18, 00);
        return this;
    }
    public ComandoEntradaTestDataBuilder fechaFuncionMiercolesJueves() {
        this.fechaFuncion = LocalDateTime.of(2021, Month.JULY, 15, 18, 00);
        return this;
    }
    public ComandoEntradaTestDataBuilder fechaFuncionViernes() {
        this.fechaFuncion = LocalDateTime.of(2021, Month.JULY, 9, 18, 00);
        return this;
    }

    public ComandoEntrada build() {
        return new ComandoEntrada(id,numeroFuncion,precio,nombrePelicula,fechaFuncion);
    }
}
