package com.ceiba.afiliado.modelo.entidad;


import com.ceiba.afiliado.utils.MensajesDeExcepcion;
import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Afiliado {
    private Long id;
    private String nombre;
    private String tipoDocumento;
    private String numeroDocumento;
    private LocalDateTime fechaNacimiento;
    private String email;
    private String direccion;
    private String telefono;
    private LocalDateTime fechaRegistro;

    public Afiliado(Long id, String nombre, String tipoDocumento, String numeroDocumento, LocalDateTime fechaNacimiento, String email, String direccion, String telefono, LocalDateTime fechaRegistro) {
        validarObligatorio(nombre,MensajesDeExcepcion.SE_DEBE_INGRESAR_EL_NOMBRE_DEL_AFILIADO.getMensaje());
        validarObligatorio(tipoDocumento,MensajesDeExcepcion.SE_DEBE_INGRESAR_EL_TIPO_DE_DOCUMENTO_DEL_AFILIADO.getMensaje());
        validarObligatorio(numeroDocumento,MensajesDeExcepcion.SE_DEBE_INGRESAR_EL_NUMERO_DE_DOCUMENTO_DEL_AFILIADO.getMensaje());
        validarObligatorio(fechaNacimiento,MensajesDeExcepcion.SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO_DEL_AFILIADO.getMensaje());
        validarObligatorio(email,MensajesDeExcepcion.SE_DEBE_INGRESAR_EL_EMAIL_DEL_AFILIADO.getMensaje());
        validarObligatorio(direccion,MensajesDeExcepcion.SE_DEBE_INGRESAR_DIRECCION_DEL_AFILIADO.getMensaje());
        validarObligatorio(telefono,MensajesDeExcepcion.SE_DEBE_INGRESAR_TELEFONO_DEL_AFILIADO.getMensaje());
        validarObligatorio(fechaRegistro,MensajesDeExcepcion.SE_DEBE_INGRESAR_LA_FECHA_DE_REGISTRO_DEL_AFILIADO.getMensaje());
        validarMenor(fechaNacimiento,fechaRegistro,MensajesDeExcepcion.LA_FECHA_DE_NACIMIENTO_NO_PUEDE_SER_MAYOR_A_LA_FECHA_DE_REGISTRO.getMensaje());
        validarRegex(email,MensajesDeExcepcion.REGEX_CORREO.getMensaje(), MensajesDeExcepcion.SE_DEBE_INGRESAR_UN_EMAIL_VALIDO.getMensaje());

        this.id = id;
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaRegistro = fechaRegistro;
    }
}
