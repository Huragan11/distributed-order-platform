# Distributed Order Platform

Microservices demo using Micronaut, gRPC, Kafka, PostgreSQL, MongoDB, Redis, and Kubernetes.

## Services

- api-gateway — REST API & auth
- order-service — order creation, persistence, Kafka producer
- inventory-service — stock management, MongoDB, Redis, Kafka consumer
- notification-service — listens to order status events, sends notifications

## How to run (dev)

```bash
./gradlew :services:api-gateway:run
