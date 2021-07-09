package com.ceiba.afiliado.servicio;

import com.ceiba.afiliado.modelo.entidad.Afiliado;
import com.ceiba.afiliado.puerto.repositorio.RepositorioAfiliado;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.afiliado.utils.MensajesDeExcepcion;

public class ServicioActualizarAfiliado {

    private final RepositorioAfiliado repositorioAfiliado;

    public ServicioActualizarAfiliado(RepositorioAfiliado repositorioAfiliado) {
        this.repositorioAfiliado = repositorioAfiliado;
    }

    public void ejecutar(Afiliado afiliado){
        validarExistenciaPrevia(afiliado);
        this.repositorioAfiliado.actualizar(afiliado);
    }

    private void validarExistenciaPrevia(Afiliado afiliado) {
        boolean existe = this.repositorioAfiliado.existe(afiliado.getTipoDocumento(),afiliado.getNumeroDocumento());
        if(!existe) {
            throw new ExcepcionSinDatos(MensajesDeExcepcion.NO_EXISTE_UN_AFILIADO_REGISTRADO_CON_ESTE_NUMERO_Y_TIPO_DE_DOCUMENTO.getMensaje());
        }
    }
}
