package com.huragan11.orders;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Serdeable
public record CreateOrderRequest(
        @NotBlank
        String customerId,
        @NotBlank
        String productId,
        @Positive
        int quantity) {
}
