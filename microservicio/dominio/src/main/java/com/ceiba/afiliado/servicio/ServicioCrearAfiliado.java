package com.ceiba.afiliado.servicio;

import com.ceiba.afiliado.modelo.entidad.Afiliado;
import com.ceiba.afiliado.puerto.repositorio.RepositorioAfiliado;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.afiliado.utils.MensajesDeExcepcion;


public class ServicioCrearAfiliado {
    private final RepositorioAfiliado repositorioAfiliado;

    public ServicioCrearAfiliado(RepositorioAfiliado repositorioAfiliado) {
        this.repositorioAfiliado = repositorioAfiliado;
    }

    public Long ejecutar(Afiliado afiliado){
        validarExistenciaPrevia(afiliado);
        return this.repositorioAfiliado.crear(afiliado);
    }

    private void validarExistenciaPrevia(Afiliado afiliado) {
        boolean existe = this.repositorioAfiliado.existe(afiliado.getTipoDocumento(),afiliado.getNumeroDocumento());
        if(existe) {
            throw new ExcepcionValorInvalido(MensajesDeExcepcion.YA_EXISTE_UN_AFILIADO_REGISTRADO_CON_ESTE_NUMERO_Y_TIPO_DE_DOCUMENTO.getMensaje());
        }
    }
}
