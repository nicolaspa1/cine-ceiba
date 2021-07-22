package com.ceiba.afiliado.servicio;

import com.ceiba.afiliado.modelo.entidad.Afiliado;
import com.ceiba.afiliado.puerto.repositorio.RepositorioAfiliado;
import com.ceiba.afiliado.utils.MensajesDeExcepcion;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.afiliado.servicio.testdatabuilder.AfiliadoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

import static org.junit.Assert.assertEquals;

public class ServicioCrearAfiliadoTest {


    @Test
    public void validarAfiliadoExistenciaPreviaTest() {
        // arrange
        Afiliado afiliado = new AfiliadoTestDataBuilder().build();
        RepositorioAfiliado repositorioAfiliado = Mockito.mock(RepositorioAfiliado.class);
        Mockito.when(repositorioAfiliado.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearAfiliado servicioCrearAfiliado = new ServicioCrearAfiliado(repositorioAfiliado);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearAfiliado.ejecutar(afiliado), ExcepcionValorInvalido.class, MensajesDeExcepcion.YA_EXISTE_UN_AFILIADO_REGISTRADO_CON_ESTE_ID.getMensaje());
    }

    @Test
    public void validarCreacionAfiliado() {
        // arrange
        Long ID = 1L;
        Afiliado afiliado = new AfiliadoTestDataBuilder().build();
        RepositorioAfiliado repositorioAfiliado = Mockito.mock(RepositorioAfiliado.class);
        Mockito.when(repositorioAfiliado.existe(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioAfiliado.crear(afiliado)).thenReturn(ID);
        ServicioCrearAfiliado servicioCrearAfiliado = new ServicioCrearAfiliado(repositorioAfiliado);
        // act - assert
        assertEquals(ID,servicioCrearAfiliado.ejecutar(afiliado));
    }
}
