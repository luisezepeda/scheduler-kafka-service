package com.kafka.producer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

/**
 * Modelo que representa la información del cliente en el payload.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @NotBlank(message = "El nombre del cliente no puede estar vacío")
    @JsonProperty("name")
    private String name;
}
