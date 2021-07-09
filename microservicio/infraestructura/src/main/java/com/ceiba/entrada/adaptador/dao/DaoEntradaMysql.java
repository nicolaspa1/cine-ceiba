package com.ceiba.entrada.adaptador.dao;

import com.ceiba.afiliado.adaptador.dao.MapeoAfiliado;
import com.ceiba.afiliado.modelo.dto.DtoAfiliado;
import com.ceiba.afiliado.puerto.dao.DaoAfiliado;
import com.ceiba.entrada.modelo.dto.DtoEntrada;
import com.ceiba.entrada.puerto.dao.DaoEntrada;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DaoEntradaMysql implements DaoEntrada {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="entrada", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="entrada", value="obtener")
    private static String sqlObtener;

    public DaoEntradaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public List<DtoEntrada> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoEntrada());
    }
}
