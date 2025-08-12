package com.kafka.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.producer.model.ClientQueryResult;
import com.kafka.producer.model.KafkaMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value("${kafka.producer.topic}")
    private String topic;

    /**
     * Publica un mensaje KafkaMessage en el topic configurado.
     * @param message objeto a publicar
     */
    public void send(KafkaMessage message) {
        try {
            String payload = objectMapper.writeValueAsString(message);
            log.debug("Enviando mensaje al topic {}: {}", topic, payload);
            kafkaTemplate.send(topic, payload);
            log.info("Mensaje enviado al topic {}", topic);
        } catch (JsonProcessingException e) {
            log.error("Error serializando el mensaje: {}", e.getMessage(), e);
            throw new IllegalArgumentException("Mensaje inválido", e);
        }
    }

    public void send(ClientQueryResult message) {
        try {
            String payload = objectMapper.writeValueAsString(message);
            log.debug("Enviando mensaje al topic {}: {}", topic, payload);
            kafkaTemplate.send(topic, payload);
            log.info("Mensaje enviado al topic {}", topic);
        } catch (JsonProcessingException e) {
            log.error("Error serializando el mensaje: {}", e.getMessage(), e);
            throw new IllegalArgumentException("Mensaje inválido", e);
        }
    }
}
