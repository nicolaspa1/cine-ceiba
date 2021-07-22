package com.ceiba.afiliado.utils;

import lombok.Getter;

@Getter
public enum MensajesDeExcepcion {
    REGEX_CORREO("^[^@]+@[^@]+\\.[a-zA-Z]{2,}$"),
    SE_DEBE_INGRESAR_EL_NOMBRE_DEL_AFILIADO("Se debe ingresar el nombre del afiliado"),
    SE_DEBE_INGRESAR_EL_TIPO_DE_DOCUMENTO_DEL_AFILIADO("Se debe ingresar el tipo de documento del afiliado"),
    SE_DEBE_INGRESAR_EL_NUMERO_DE_DOCUMENTO_DEL_AFILIADO("Se debe ingresar el numero de documento del afiliado"),
    SE_DEBE_INGRESAR_EL_EMAIL_DEL_AFILIADO("Se debe ingresar el email del afiliado"),
    SE_DEBE_INGRESAR_UN_EMAIL_VALIDO("Se debe ingresar un email valido con una estructura como la siguiente (ceiba@mail.com)"),
    SE_DEBE_INGRESAR_DIRECCION_DEL_AFILIADO("Se debe ingresar la direccion del afiliado"),
    SE_DEBE_INGRESAR_TELEFONO_DEL_AFILIADO("Se debe ingresar el telefono del afiliado"),
    SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO_DEL_AFILIADO("Se debe ingresar la fecha de nacimiento del afiliado"),
    SE_DEBE_INGRESAR_LA_FECHA_DE_REGISTRO_DEL_AFILIADO("Se debe ingresar la fecha de registro del afiliado"),
    LA_FECHA_DE_NACIMIENTO_NO_PUEDE_SER_MAYOR_A_LA_FECHA_DE_REGISTRO("Fecha de nacimiento no puede ser mayor a la de registro"),
    YA_EXISTE_UN_AFILIADO_REGISTRADO_CON_ESTE_NUMERO_Y_TIPO_DE_DOCUMENTO("Ya existe un afiliado con este tipo y numero de documento"),
    NO_EXISTE_UN_AFILIADO_REGISTRADO_CON_ESTE_NUMERO_Y_TIPO_DE_DOCUMENTO("No existe un afiliado con este tipo y numero de documento"),
    YA_EXISTE_UN_AFILIADO_REGISTRADO_CON_ESTE_ID("Ya existe un afiliado con este id"),
    NO_EXISTE_UN_AFILIADO_REGISTRADO_CON_ESTE_ID("No existe un afiliado con este id");



    private  String mensaje;

    MensajesDeExcepcion(String mensaje){
        this.mensaje=mensaje;
    }
}
