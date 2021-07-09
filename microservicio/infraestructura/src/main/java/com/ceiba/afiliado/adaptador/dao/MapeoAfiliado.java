package com.ceiba.afiliado.adaptador.dao;

import com.ceiba.afiliado.modelo.dto.DtoAfiliado;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoAfiliado implements RowMapper<DtoAfiliado>, MapperResult {

    @Override
    public DtoAfiliado mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String tipoDocumento = resultSet.getString("tipo_documento");
        String numeroDocumento= resultSet.getString("numero_documento");
        LocalDateTime fechaNacimiento = extraerLocalDateTime(resultSet, "fecha_nacimiento");;
        String email= resultSet.getString("email");
        String direccion= resultSet.getString("direccion");
        String telefono= resultSet.getString("telefono");
        LocalDateTime fechaRegistro = extraerLocalDateTime(resultSet, "fecha_registro");;

        return new DtoAfiliado(id,nombre,tipoDocumento,numeroDocumento,fechaNacimiento,email,direccion,
                telefono,fechaRegistro);
    }

}
