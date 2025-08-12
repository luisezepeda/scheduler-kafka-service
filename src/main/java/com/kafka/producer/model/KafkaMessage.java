package com.kafka.producer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.Valid;
import java.util.List;

/**
 * Modelo principal que representa un mensaje de Kafka completo.
 * Estructura basada en el formato de mensajes VisitRequest.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KafkaMessage {

    @NotEmpty(message = "El tipo de detalle no puede estar vacío")
    @JsonProperty("detail-type")
    private List<String> detailType;

    @NotEmpty(message = "La fuente del mensaje no puede estar vacía")
    @JsonProperty("source")
    private List<String> source;

    @NotNull(message = "El detalle del mensaje no puede ser nulo")
    @Valid
    @JsonProperty("detail")
    private Detail detail;
}
