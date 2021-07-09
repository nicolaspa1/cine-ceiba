package com.ceiba.afiliado.adaptador.repositorio;

import com.ceiba.afiliado.modelo.entidad.Afiliado;
import com.ceiba.afiliado.puerto.repositorio.RepositorioAfiliado;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioAfiliadoMysql implements RepositorioAfiliado {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="afiliado", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="afiliado", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="afiliado", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="afiliado", value="existe")
    private static String sqlExiste;


    public RepositorioAfiliadoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public Long crear(Afiliado afiliado) {
        return this.customNamedParameterJdbcTemplate.crear(afiliado, sqlCrear);
    }

    @Override
    public void actualizar(Afiliado afiliado) {
        this.customNamedParameterJdbcTemplate.actualizar(afiliado, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(String tipoDocumento, String numeroDocumento) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("tipoDocumento", tipoDocumento);
        paramSource.addValue("numeroDocumento", numeroDocumento);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource, Boolean.class);
    }
}
