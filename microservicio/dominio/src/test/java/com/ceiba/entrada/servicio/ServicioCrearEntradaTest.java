package com.ceiba.entrada.servicio;


import com.ceiba.BasePrueba;
import com.ceiba.afiliado.modelo.entidad.Afiliado;
import com.ceiba.afiliado.puerto.repositorio.RepositorioAfiliado;
import com.ceiba.afiliado.servicio.testdatabuilder.AfiliadoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.entrada.modelo.entidad.Entrada;
import com.ceiba.entrada.puerto.repositorio.RepositorioEntrada;
import com.ceiba.entrada.servicio.testdatabuilder.EntradaTestDataBuilder;
import com.ceiba.entrada.utils.MensajesDeExcepcionEntrada;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class ServicioCrearEntradaTest {

    @Test
    public void validarEntradaExistenciaPreviaTest() {
        // arrange
        Entrada entrada  = new EntradaTestDataBuilder().build();
        RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
        ServicioCalcularPrecioEntrada servicioCalcularPrecioEntrada = new ServicioCalcularPrecioEntrada();

        Mockito.when(repositorioEntrada.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearEntrada servicioCrearEntrada = new ServicioCrearEntrada(repositorioEntrada,servicioCalcularPrecioEntrada);

        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearEntrada.ejecutar(entrada), ExcepcionDuplicidad.class, MensajesDeExcepcionEntrada.YA_EXISTE_UNA_ENTRADA_REGISTRADA_CON_ESTE_ID.getMensaje());
    }

    @Test
    public void validarCreacionEntrada() {
        // arrange
        Long ID = 1L;
        Entrada entrada = new EntradaTestDataBuilder().build();
        RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
        ServicioCalcularPrecioEntrada servicioCalcularPrecioEntrada = new ServicioCalcularPrecioEntrada();
        Mockito.when(repositorioEntrada.existe(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioEntrada.crear(entrada)).thenReturn(ID);
        ServicioCrearEntrada servicioCrearEntrada = new ServicioCrearEntrada(repositorioEntrada,servicioCalcularPrecioEntrada);
        // act - assert
        assertEquals(ID,servicioCrearEntrada.ejecutar(entrada));
    }
    @Test
    public void validarCreacionEntradaConAfiliado() {
        // arrange
        Long ID = 1L;
        Entrada entrada = new EntradaTestDataBuilder().build();
        Afiliado afiliado = new AfiliadoTestDataBuilder().build();
        RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
        RepositorioAfiliado repositorioAfiliado = Mockito.mock(RepositorioAfiliado.class);
        ServicioCalcularPrecioEntradaAfiliado servicioCalcularPrecioEntradaAfiliado = new ServicioCalcularPrecioEntradaAfiliado(repositorioEntrada);
        Mockito.when(repositorioEntrada.existe(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioAfiliado.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioEntrada.crear(entrada)).thenReturn(ID);
        ServicioCrearEntradaAfiliado servicioCrearEntradaAfiliado = new ServicioCrearEntradaAfiliado(repositorioEntrada,repositorioAfiliado,servicioCalcularPrecioEntradaAfiliado);
        // act - assert
        assertEquals(ID,servicioCrearEntradaAfiliado.ejecutar(entrada,afiliado));
    }
}
