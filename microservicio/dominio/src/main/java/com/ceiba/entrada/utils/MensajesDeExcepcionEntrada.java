package com.ceiba.entrada.utils;

import lombok.Getter;

@Getter
public enum MensajesDeExcepcionEntrada {
    SE_DEBE_INGRESAR_EL_NUMERO_DE_LA_FUNCION("Se debe ingresar el numero de la funcion del dia"),
    SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_FUNCION("Se debe ingresar el nombre de la funcion"),
    SE_DEBE_INGRESAR_EL_PRECIO_DE_LA_ENTRADA("Se debe ingresar el precio de la entrada"),
    SE_DEBE_INGRESAR_LA_FECHA_DE_LA_FUNCION("Se debe ingresar la fecha de la funcion de la pelicula"),

    YA_EXISTE_UNA_ENTRADA_REGISTRADA_CON_ESTE_ID("Entrada no disponible a la venta (ya se vendio :c)"),
    NO_EXISTE_UNA_ENTRADA_REGISTRADA_CON_ESTE_ID("La entrada no existe");




    private  String mensaje;

    MensajesDeExcepcionEntrada(String mensaje){
        this.mensaje=mensaje;
    }
}
