package com.ceiba.afiliado.adaptador.dao;

import com.ceiba.afiliado.modelo.dto.DtoAfiliado;
import com.ceiba.afiliado.puerto.dao.DaoAfiliado;
import com.ceiba.entrada.modelo.dto.DtoEntrada;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DaoAfiliadoMysql implements DaoAfiliado {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="afiliado", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="afiliado", value="obtener")
    private static String sqlObtener;

    public DaoAfiliadoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public List<DtoAfiliado> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoAfiliado());
    }

    @Override
    public Optional<DtoAfiliado> obtenerAfiliadoPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        List<DtoAfiliado> list=this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtener, paramSource, new MapeoAfiliado());
        if(list.size()==1){
            return Optional.of(list.get(0));
        }
        return Optional.empty();
    }
}
