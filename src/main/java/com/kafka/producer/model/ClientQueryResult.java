package com.kafka.producer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Modelo para mapear resultados de la consulta a la tabla clients.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientQueryResult {
    private Long id;
    private String reference;
    private String status;
}
