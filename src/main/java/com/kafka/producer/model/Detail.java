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
 * Modelo que representa el detalle del mensaje Kafka.
 * Contiene el nombre del evento, headers y payload.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Detail {

    @NotEmpty(message = "El nombre del evento no puede estar vacío")
    @JsonProperty("eventName")
    private List<String> eventName;

    @NotNull(message = "Los headers no pueden ser nulos")
    @Valid
    @JsonProperty("headers")
    private Headers headers;

    @NotNull(message = "El payload no puede ser nulo")
    @Valid
    @JsonProperty("payload")
    private Payload payload;
}
