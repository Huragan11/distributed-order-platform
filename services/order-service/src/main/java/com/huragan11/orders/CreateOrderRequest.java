package com.huragan11.orders;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record CreateOrderRequest(String customerId, String productId, int quantity) {
}
