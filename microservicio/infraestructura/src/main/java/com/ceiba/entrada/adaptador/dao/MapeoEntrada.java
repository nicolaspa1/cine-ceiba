package com.ceiba.entrada.adaptador.dao;

import com.ceiba.afiliado.modelo.dto.DtoAfiliado;
import com.ceiba.entrada.modelo.dto.DtoEntrada;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoEntrada implements RowMapper<DtoEntrada>, MapperResult {

    @Override
    public DtoEntrada mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");;
        Integer numeroFuncion = resultSet.getInt("numero_funcion");;
        Double precio = resultSet.getDouble("precio");;
        String nombrePelicula = resultSet.getString("nombre_pelicula");;
        LocalDateTime fechaFuncion = extraerLocalDateTime(resultSet, "fecha_funcion");;


        return new DtoEntrada(id,numeroFuncion,precio,nombrePelicula,fechaFuncion);
    }

}
