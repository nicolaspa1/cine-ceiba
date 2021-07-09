package com.ceiba.entrada.servicio.testdatabuilder;

import com.ceiba.afiliado.servicio.testdatabuilder.AfiliadoTestDataBuilder;
import com.ceiba.entrada.modelo.entidad.Entrada;

import java.time.LocalDateTime;
import java.time.Month;

public class EntradaTestDataBuilder {
    private   Long id;
    private   Integer numeroFuncion;
    private   Double precio;
    private   String nombrePelicula;
    private   LocalDateTime fechaFuncion;

    public EntradaTestDataBuilder() {
        this.id = 2L;
        this.numeroFuncion = 2;
        this.precio = 10000.0;
        this.nombrePelicula = "Tron";
        this.fechaFuncion = LocalDateTime.now().plusDays(4);
    }
    public EntradaTestDataBuilder fechaFuncionFinDeSemana() {
        this.fechaFuncion = LocalDateTime.of(2021, Month.JULY, 10, 18, 00);
        return this;
    }
    public EntradaTestDataBuilder fechaFuncionLunesMartes() {
        this.fechaFuncion = LocalDateTime.of(2021, Month.JULY, 13, 18, 00);
        return this;
    }
    public EntradaTestDataBuilder fechaFuncionMiercolesJueves() {
        this.fechaFuncion = LocalDateTime.of(2021, Month.JULY, 15, 18, 00);
        return this;
    }
    public EntradaTestDataBuilder fechaFuncionViernes() {
        this.fechaFuncion = LocalDateTime.of(2021, Month.JULY, 9, 18, 00);
        return this;
    }

    public Entrada build() {
        return new Entrada(id,numeroFuncion,precio,nombrePelicula,fechaFuncion);
    }
}
