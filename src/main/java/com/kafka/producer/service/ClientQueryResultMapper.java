package com.kafka.producer.service;

import com.kafka.producer.model.ClientQueryResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper para mapear filas de la consulta a ClientQueryResult.
 */
public class ClientQueryResultMapper implements RowMapper<ClientQueryResult> {
    @Override
    public ClientQueryResult mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ClientQueryResult.builder()
                .id(rs.getLong("id"))
                .reference(rs.getString("reference"))
                .status(rs.getString("status"))
                .build();
    }
}
