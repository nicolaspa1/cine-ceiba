package com.ceiba.configuracion;

import com.ceiba.afiliado.puerto.repositorio.RepositorioAfiliado;
import com.ceiba.afiliado.servicio.ServicioActualizarAfiliado;
import com.ceiba.afiliado.servicio.ServicioCrearAfiliado;
import com.ceiba.afiliado.servicio.ServicioEliminarAfiliado;
import com.ceiba.entrada.puerto.repositorio.RepositorioEntrada;
import com.ceiba.entrada.servicio.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearAfiliado servicioCrearAfiliado(RepositorioAfiliado repositorioAfiliado) {
        return new ServicioCrearAfiliado(repositorioAfiliado);
    }

    @Bean
    public ServicioEliminarAfiliado servicioEliminarAfiliado(RepositorioAfiliado repositorioAfiliado) {
        return new ServicioEliminarAfiliado(repositorioAfiliado);
    }

    @Bean
    public ServicioActualizarAfiliado servicioActualizarAfiliado(RepositorioAfiliado repositorioAfiliado) {
        return new ServicioActualizarAfiliado(repositorioAfiliado);
    }

    @Bean
    public ServicioCrearEntrada servicioCrearEntrada (RepositorioEntrada repositorioEntrada,ServicioCalcularPrecioEntrada servicioCalcularPrecioEntrada) {
        return new ServicioCrearEntrada(repositorioEntrada,servicioCalcularPrecioEntrada);
    }

    @Bean
    public ServicioCrearEntradaAfiliado servicioCrearEntradaAfiliado (RepositorioEntrada repositorioEntrada, RepositorioAfiliado repositorioAfiliado, ServicioCalcularPrecioEntradaAfiliado servicioCalcularPrecioEntradaAfiliado) {
        return new ServicioCrearEntradaAfiliado(repositorioEntrada,repositorioAfiliado,servicioCalcularPrecioEntradaAfiliado);
    }

    @Bean
    public ServicioEliminarEntrada servicioEliminarEntrada(RepositorioEntrada repositorioEntrada) {
        return new ServicioEliminarEntrada(repositorioEntrada);
    }

    @Bean
    public ServicioCalcularPrecioEntrada servicioCalcularPrecioEntrada() {
        return new ServicioCalcularPrecioEntrada();
    }
    @Bean
    public ServicioCalcularPrecioEntradaAfiliado servicioCalcularPrecioEntradaAfiliado(RepositorioEntrada repositorioEntrada) {
        return new ServicioCalcularPrecioEntradaAfiliado(repositorioEntrada);
    }


}
