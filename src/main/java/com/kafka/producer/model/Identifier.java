package com.kafka.producer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

/**
 * Modelo que representa un identificador en el header del mensaje.
 * Contiene código, descripción y valor de referencia.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Identifier {

    @NotBlank(message = "El código del identificador no puede estar vacío")
    @JsonProperty("code")
    private String code;

    @NotBlank(message = "La descripción del identificador no puede estar vacía")
    @JsonProperty("description")
    private String description;

    @NotBlank(message = "El valor del identificador no puede estar vacío")
    @JsonProperty("value")
    private String value;
}
