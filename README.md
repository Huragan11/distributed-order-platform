# distributed-order-platform

A learning project: an order-processing platform built as Micronaut microservices.

## Stack

Java 21, Micronaut, gRPC, Kafka / RabbitMQ, PostgreSQL / MongoDB / Redis,
JUnit 5 + Testcontainers, Prometheus / Grafana / OpenSearch, Docker, Kubernetes, GitLab CI.

## Roadmap

- [x] 0. Gradle multi-project skeleton
- [x] 1. `order-service`: first Micronaut endpoint
- [x] 2. Tests: JUnit 5 + Micronaut Test
- [ ] 3. PostgreSQL + Micronaut Data + Flyway + Testcontainers
- [ ] 4. `inventory-service` + gRPC
- [ ] 5. Kafka events (outbox), RabbitMQ comparison
- [ ] 6. Redis (idempotency, cache), MongoDB (`notification-service`)
- [ ] 7. Observability: Prometheus, Grafana, OpenSearch, alerting
- [ ] 8. Docker + Kubernetes
- [ ] 9. GitLab CI

## Build

```bash
./gradlew build
```
