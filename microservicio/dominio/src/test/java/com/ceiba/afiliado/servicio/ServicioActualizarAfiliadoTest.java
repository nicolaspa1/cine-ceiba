package com.ceiba.afiliado.servicio;

import com.ceiba.afiliado.modelo.entidad.Afiliado;
import com.ceiba.afiliado.puerto.repositorio.RepositorioAfiliado;
import com.ceiba.afiliado.utils.MensajesDeExcepcion;
import com.ceiba.afiliado.servicio.testdatabuilder.AfiliadoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import org.junit.Test;
import org.mockito.Mockito;


import com.ceiba.BasePrueba;

import static org.mockito.Mockito.*;

public class ServicioActualizarAfiliadoTest {

    @Test
    public void validarAfiliadoExistenciaPreviaTest() {
        // arrange
        Afiliado afiliado = new AfiliadoTestDataBuilder().build();
        RepositorioAfiliado repositorioAfiliado = Mockito.mock(RepositorioAfiliado.class);
        Mockito.when(repositorioAfiliado.existe(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarAfiliado servicioActualizarAfiliado = new ServicioActualizarAfiliado(repositorioAfiliado);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarAfiliado.ejecutar(afiliado), ExcepcionSinDatos.class, MensajesDeExcepcion.NO_EXISTE_UN_AFILIADO_REGISTRADO_CON_ESTE_ID.getMensaje());
    }

    @Test
    public void validarActualizacionAfiliadoTest() {
        // arrange
        Afiliado afiliado = new AfiliadoTestDataBuilder().build();
        RepositorioAfiliado repositorioAfiliado = Mockito.mock(RepositorioAfiliado.class);
        Mockito.when(repositorioAfiliado.existe(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarAfiliado servicioActualizarAfiliado = new ServicioActualizarAfiliado(repositorioAfiliado);
        // act - assert
        servicioActualizarAfiliado.ejecutar(afiliado);
        verify(repositorioAfiliado,times(1)).actualizar(afiliado);
    }
}
