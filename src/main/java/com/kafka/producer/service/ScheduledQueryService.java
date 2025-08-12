package com.kafka.producer.service;

import com.kafka.producer.model.ClientQueryResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduledQueryService {

    private final JdbcTemplate jdbcTemplate;
    private final MessageProducerService messageProducerService;

    @Value("${scheduler.enabled:true}")
    private boolean schedulerEnabled;

    @Value("${scheduler.query}")
    private String query;

    /**
     * Ejecuta según cron configurado (por defecto cada hora al minuto 0) la consulta configurada y publica un mensaje por cada fila.
     * Cron: segundo minuto hora díaMes mes díaSemana
     */
    @Scheduled(cron = "${scheduler.cron:0 0 * * * *}")
    public void runHourlyQueryAndPublish() {
        if (!schedulerEnabled) {
            log.debug("Scheduler deshabilitado por configuración");
            return;
        }
        log.info("Ejecutando tarea programada: consulta a MySQL y envío a Kafka");
        try {
            List<ClientQueryResult> results = jdbcTemplate.query(query, new ClientQueryResultMapper());
            log.info("Filas obtenidas: {}", results.size());

            // Si deseas seguir publicando a Kafka por cada fila, adapta el mapeo aquí
            for (ClientQueryResult row : results) {
                messageProducerService.send(row);
            }
        } catch (Exception e) {
            log.error("Error ejecutando tarea programada: {}", e.getMessage(), e);
        }
    }
}
