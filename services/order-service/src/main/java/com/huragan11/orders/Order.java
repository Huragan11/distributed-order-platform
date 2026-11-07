package com.huragan11.orders;

import io.micronaut.serde.annotation.Serdeable;

import java.util.UUID;

@Serdeable
public record Order(UUID id, String customerId, String productId, int quantity) {
}
