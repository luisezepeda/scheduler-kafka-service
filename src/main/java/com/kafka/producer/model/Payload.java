package com.kafka.producer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;

/**
 * Modelo que representa el payload del mensaje Kafka.
 * Contiene información del cliente y contacto.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payload {

    @NotNull(message = "La información del cliente no puede ser nula")
    @Valid
    @JsonProperty("client")
    private Client client;

    @NotNull(message = "La información de contacto no puede ser nula")
    @Valid
    @JsonProperty("contact")
    private Contact contact;
}
