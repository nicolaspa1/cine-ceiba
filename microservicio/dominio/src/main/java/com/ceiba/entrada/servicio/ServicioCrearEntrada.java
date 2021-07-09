package com.ceiba.entrada.servicio;

import com.ceiba.afiliado.modelo.entidad.Afiliado;
import com.ceiba.afiliado.puerto.repositorio.RepositorioAfiliado;
import com.ceiba.afiliado.utils.MensajesDeExcepcion;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.entrada.modelo.entidad.Entrada;
import com.ceiba.entrada.puerto.repositorio.RepositorioEntrada;
import com.ceiba.entrada.utils.MensajesDeExcepcionEntrada;


public class ServicioCrearEntrada {
    private final RepositorioEntrada repositorioEntrada;
    private final RepositorioAfiliado repositorioAfiliado;

    private final ServicioCalcularPrecioEntrada servicioCalcularPrecioEntrada;

    public ServicioCrearEntrada(RepositorioEntrada repositorioEntrada, RepositorioAfiliado repositorioAfiliado, ServicioCalcularPrecioEntrada servicioCalcularPrecioEntrada) {
        this.repositorioEntrada = repositorioEntrada;
        this.repositorioAfiliado = repositorioAfiliado;
        this.servicioCalcularPrecioEntrada = servicioCalcularPrecioEntrada;
    }

    public Long ejecutar(Entrada entrada, Afiliado afiliado) {
        validarEntradaPrevia(entrada);
        validarExistenciaAfiliado(afiliado.getTipoDocumento(),afiliado.getNumeroDocumento());
        entrada.setPrecio(servicioCalcularPrecioEntrada.ejecutar(entrada,afiliado));
        return this.repositorioEntrada.crear(entrada);
    }
    public Long ejecutar(Entrada entrada) {
        validarEntradaPrevia(entrada);
        entrada.setPrecio(servicioCalcularPrecioEntrada.ejecutar(entrada));
        return this.repositorioEntrada.crear(entrada);
    }

    private void validarEntradaPrevia(Entrada entrada) {
        boolean existe = this.repositorioEntrada.existe(entrada.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(MensajesDeExcepcionEntrada.YA_EXISTE_UNA_ENTRADA_REGISTRADA_CON_ESTE_ID.getMensaje());
        }
    }
    private void validarExistenciaAfiliado(String tipoDocumento,String numeroDocumento) {
        boolean existe = this.repositorioAfiliado.existe(tipoDocumento,numeroDocumento);
        if (!existe){
            throw new ExcepcionDuplicidad(MensajesDeExcepcion.NO_EXISTE_UN_AFILIADO_REGISTRADO_CON_ESTE_NUMERO_Y_TIPO_DE_DOCUMENTO.getMensaje());
        }
    }



}
