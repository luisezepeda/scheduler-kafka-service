package com.kafka.producer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * Modelo que representa la información de contacto en el payload.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @NotBlank(message = "El número de contacto no puede estar vacío")
    @Pattern(regexp = "^\\d{10,15}$", message = "El número de contacto debe tener entre 10 y 15 dígitos")
    @JsonProperty("number")
    private String number;
}
