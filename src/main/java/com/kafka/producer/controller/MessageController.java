package com.kafka.producer.controller;

import com.kafka.producer.model.KafkaMessage;
import com.kafka.producer.service.MessageProducerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageProducerService messageProducerService;

    @PostMapping
    public ResponseEntity<Void> publish(@Valid @RequestBody KafkaMessage message) {
        log.debug("Petición para publicar mensaje recibida");
        messageProducerService.send(message);
        return ResponseEntity.accepted().build();
    }
}
