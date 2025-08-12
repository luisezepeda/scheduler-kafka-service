package com.kafka.producer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;
import java.util.List;

/**
 * Modelo que representa los headers del mensaje Kafka.
 * Contiene el ID de aplicación y una lista de identificadores.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Headers {

    @NotBlank(message = "El ID de aplicación no puede estar vacío")
    @JsonProperty("applicationId")
    private String applicationId;

    @NotNull(message = "La lista de identificadores no puede ser nula")
    @Valid
    @JsonProperty("identifiers")
    private List<Identifier> identifiers;
}
