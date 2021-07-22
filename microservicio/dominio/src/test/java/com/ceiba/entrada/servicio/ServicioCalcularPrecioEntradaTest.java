package com.ceiba.entrada.servicio;

import com.ceiba.afiliado.modelo.entidad.Afiliado;
import com.ceiba.afiliado.puerto.repositorio.RepositorioAfiliado;
import com.ceiba.afiliado.servicio.testdatabuilder.AfiliadoTestDataBuilder;
import com.ceiba.entrada.modelo.entidad.Entrada;
import com.ceiba.entrada.puerto.repositorio.RepositorioEntrada;

import com.ceiba.entrada.servicio.testdatabuilder.EntradaTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCalcularPrecioEntradaTest {
    @Test
    public void validarPrecioLunesMartesAfiliado() {
        // arrange
        Entrada entrada = new EntradaTestDataBuilder().fechaFuncionLunesMartes().build();
        Afiliado afiliado = new AfiliadoTestDataBuilder().build();

        RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
        RepositorioAfiliado repositorioAfiliado = Mockito.mock(RepositorioAfiliado.class);

        Mockito.when(repositorioEntrada.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioAfiliado.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioEntrada.ofertaDeAfiliado(Mockito.anyString(),Mockito.anyString())).thenReturn(true);

        ServicioCalcularPrecioEntrada servicioCalcularPrecioEntrada = new ServicioCalcularPrecioEntrada(repositorioEntrada);

        // act - assert
        assertEquals (5000, servicioCalcularPrecioEntrada.ejecutar(entrada,afiliado).doubleValue());
    }
    @Test
    public void validarPrecioMiercolesJuevesAfiliado() {
        // arrange
        Entrada entrada = new EntradaTestDataBuilder().fechaFuncionMiercolesJueves().build();
        Afiliado afiliado = new AfiliadoTestDataBuilder().build();

        RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
        RepositorioAfiliado repositorioAfiliado = Mockito.mock(RepositorioAfiliado.class);

        Mockito.when(repositorioEntrada.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioAfiliado.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioEntrada.ofertaDeAfiliado(Mockito.anyString(),Mockito.anyString())).thenReturn(true);

        ServicioCalcularPrecioEntrada servicioCalcularPrecioEntrada = new ServicioCalcularPrecioEntrada(repositorioEntrada);

        // act - assert
        assertEquals (5000, servicioCalcularPrecioEntrada.ejecutar(entrada,afiliado).doubleValue());
    }
    @Test
    public void validarPrecioViernesAfiliado() {
        // arrange
        Entrada entrada = new EntradaTestDataBuilder().fechaFuncionViernes().build();
        Afiliado afiliado = new AfiliadoTestDataBuilder().build();

        RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
        RepositorioAfiliado repositorioAfiliado = Mockito.mock(RepositorioAfiliado.class);

        Mockito.when(repositorioEntrada.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioAfiliado.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioEntrada.ofertaDeAfiliado(Mockito.anyString(),Mockito.anyString())).thenReturn(true);

        ServicioCalcularPrecioEntrada servicioCalcularPrecioEntrada = new ServicioCalcularPrecioEntrada(repositorioEntrada);

        // act - assert
        assertEquals (7000, servicioCalcularPrecioEntrada.ejecutar(entrada,afiliado).doubleValue());
    }
    @Test
    public void validarPrecioFinDeSemanaAfiliado() {
        // arrange
        Entrada entrada = new EntradaTestDataBuilder().fechaFuncionFinDeSemana().build();
        Afiliado afiliado = new AfiliadoTestDataBuilder().build();


        RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);
        RepositorioAfiliado repositorioAfiliado = Mockito.mock(RepositorioAfiliado.class);

        Mockito.when(repositorioEntrada.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioAfiliado.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioEntrada.ofertaDeAfiliado(Mockito.anyString(),Mockito.anyString())).thenReturn(true);

        ServicioCalcularPrecioEntrada servicioCalcularPrecioEntrada = new ServicioCalcularPrecioEntrada(repositorioEntrada);

        // act - assert
        assertEquals (10000, servicioCalcularPrecioEntrada.ejecutar(entrada,afiliado).doubleValue());
    }


    @Test
    public void validarPrecioLunesMartesNoAfiliado() {
        // arrange
        Entrada entrada = new EntradaTestDataBuilder().fechaFuncionLunesMartes().build();

        RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);

        Mockito.when(repositorioEntrada.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioEntrada.ofertaDeAfiliado(Mockito.anyString(),Mockito.anyString())).thenReturn(true);

        ServicioCalcularPrecioEntrada servicioCalcularPrecioEntrada = new ServicioCalcularPrecioEntrada(repositorioEntrada);

        // act - assert
        assertEquals (9000, servicioCalcularPrecioEntrada.ejecutar(entrada).doubleValue());
    }
    @Test
    public void validarPrecioMiercolesJuevesNoAfiliado() {
        // arrange
        Entrada entrada = new EntradaTestDataBuilder().fechaFuncionMiercolesJueves().build();

        RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);

        Mockito.when(repositorioEntrada.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioEntrada.ofertaDeAfiliado(Mockito.anyString(),Mockito.anyString())).thenReturn(true);

        ServicioCalcularPrecioEntrada servicioCalcularPrecioEntrada = new ServicioCalcularPrecioEntrada(repositorioEntrada);

        // act - assert
        assertEquals (10000, servicioCalcularPrecioEntrada.ejecutar(entrada).doubleValue());
    }
    @Test
    public void validarPrecioViernesNoAfiliado() {
        // arrange
        Entrada entrada = new EntradaTestDataBuilder().fechaFuncionViernes().build();

        RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);

        Mockito.when(repositorioEntrada.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioEntrada.ofertaDeAfiliado(Mockito.anyString(),Mockito.anyString())).thenReturn(true);

        ServicioCalcularPrecioEntrada servicioCalcularPrecioEntrada = new ServicioCalcularPrecioEntrada(repositorioEntrada);

        // act - assert
        assertEquals (10000, servicioCalcularPrecioEntrada.ejecutar(entrada).doubleValue());
    }
    @Test
    public void validarPrecioFinDeSemanaNoAfiliado() {
        // arrange
        Entrada entrada = new EntradaTestDataBuilder().fechaFuncionFinDeSemana().build();

        RepositorioEntrada repositorioEntrada = Mockito.mock(RepositorioEntrada.class);

        Mockito.when(repositorioEntrada.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioEntrada.ofertaDeAfiliado(Mockito.anyString(),Mockito.anyString())).thenReturn(true);

        ServicioCalcularPrecioEntrada servicioCalcularPrecioEntrada = new ServicioCalcularPrecioEntrada(repositorioEntrada);

        // act - assert
        assertEquals (12500, servicioCalcularPrecioEntrada.ejecutar(entrada).doubleValue());
    }
}
