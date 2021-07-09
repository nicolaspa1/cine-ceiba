package com.ceiba.entrada.modelo.entidad;


import com.ceiba.entrada.utils.MensajesDeExcepcionEntrada;
import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Entrada {

    private  final Long id;
    private  final Integer numeroFuncion;
    private  Double precio;
    private  final String nombrePelicula;
    private  final LocalDateTime fechaFuncion;

    public Entrada(Long id, Integer numeroFuncion, Double precio, String nombrePelicula, LocalDateTime fechaFuncion) {
        validarObligatorio(numeroFuncion,MensajesDeExcepcionEntrada.SE_DEBE_INGRESAR_EL_NUMERO_DE_LA_FUNCION.getMensaje());
        validarObligatorio(precio,MensajesDeExcepcionEntrada.SE_DEBE_INGRESAR_EL_PRECIO_DE_LA_ENTRADA.getMensaje());
        validarObligatorio(nombrePelicula,MensajesDeExcepcionEntrada.SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_FUNCION.getMensaje());
        validarObligatorio(fechaFuncion,MensajesDeExcepcionEntrada.SE_DEBE_INGRESAR_LA_FECHA_DE_LA_FUNCION.getMensaje());
        this.id = id;
        this.numeroFuncion = numeroFuncion;
        this.precio = precio;
        this.nombrePelicula = nombrePelicula;
        this.fechaFuncion = fechaFuncion;
    }

    public boolean promoLunesMartes(){
        return this.fechaFuncion.getDayOfWeek() == DayOfWeek.MONDAY || this.fechaFuncion.getDayOfWeek() == DayOfWeek.TUESDAY;
    }
    public boolean promoViernes(){
        return this.fechaFuncion.getDayOfWeek() == DayOfWeek.FRIDAY;
    }
    public boolean promoMiercolesJueves(){
        return this.fechaFuncion.getDayOfWeek() == DayOfWeek.WEDNESDAY || this.fechaFuncion.getDayOfWeek() == DayOfWeek.THURSDAY;
    }
    public boolean promoFinDeSemana(){
        return this.fechaFuncion.getDayOfWeek() == DayOfWeek.SATURDAY || this.fechaFuncion.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
