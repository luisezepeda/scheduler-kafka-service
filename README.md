# Kafka Producer

Microservicio para publicar mensajes en Apache Kafka.

## Requisitos
- Java 17
- Maven 3.9+
- Kafka accesible (por ejemplo en WSL2). Para WSL2 estable, configure el broker con `advertised.listeners=PLAINTEXT://localhost:9092` y use `kafka.server: localhost:9092`.

## Configuración
Edite `src/main/resources/application.yml`:

```yaml
kafka:
  server: localhost:9092
  producer:
    topic: visit-request-topic
    acks: all
    retries: 3
```

## Ejecutar
- Compilar y ejecutar:
```bash
mvn spring-boot:run
```

## Uso
Enviar un mensaje (estructura VisitRequest) vía HTTP:

```bash
curl -X POST http://localhost:8080/api/messages \
  -H "Content-Type: application/json" \
  -d '{
  "detail-type": ["VisitRequest"],
  "source": ["api-microservice-global-name"],
  "detail": {
    "eventName": ["VisitRequest"],
    "headers": {
      "applicationId": "0001",
      "identifiers": [
        {"code": "00", "description": "Reference C", "value": "CR0001"},
        {"code": "01", "description": "Reference O", "value": "0001"}
      ]
    },
    "payload": {
      "client": {"name": "Luis"},
      "contact": {"number": "0123456789"}
    }
  }
}'
```

## Paquetes
- `com.kafka.producer.config`: configuración del productor Kafka.
- `com.kafka.producer.model`: modelos del mensaje.
- `com.kafka.producer.service`: servicio para publicar mensajes.
- `com.kafka.producer.controller`: endpoint REST para publicar.

## Notas
- Se usa `@Slf4j` para logs.
- Los modelos validan entradas con `jakarta.validation`.
