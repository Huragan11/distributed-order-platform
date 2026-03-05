package com.huragan11.shared.events.v1;

import java.time.Instant;
import java.util.List;

public record OrderCreatedEvent(
        String eventId,
        Instant occurredAt,
        String orderId,
        List<OrderItem> items
) {
    public record OrderItem(
            String productId,
            int quantity
    ) {}
}
