package com.ceiba.afiliado.servicio;

import com.ceiba.afiliado.modelo.entidad.Afiliado;
import com.ceiba.afiliado.puerto.repositorio.RepositorioAfiliado;
import com.ceiba.afiliado.utils.MensajesDeExcepcion;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.afiliado.servicio.testdatabuilder.AfiliadoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

public class ServicioCrearAfiliadoTest {


    @Test
    public void validarAfiliadoExistenciaPreviaTest() {
        // arrange
        Afiliado afiliado = new AfiliadoTestDataBuilder().build();
        RepositorioAfiliado repositorioAfiliado = Mockito.mock(RepositorioAfiliado.class);
        Mockito.when(repositorioAfiliado.existe(Mockito.anyString(),Mockito.anyString())).thenReturn(true);
        ServicioCrearAfiliado servicioCrearAfiliado = new ServicioCrearAfiliado(repositorioAfiliado);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearAfiliado.ejecutar(afiliado), ExcepcionDuplicidad.class, MensajesDeExcepcion.YA_EXISTE_UN_AFILIADO_REGISTRADO_CON_ESTE_NUMERO_Y_TIPO_DE_DOCUMENTO.getMensaje());
    }
}
