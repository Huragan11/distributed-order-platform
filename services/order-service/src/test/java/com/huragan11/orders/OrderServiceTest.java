package com.huragan11.orders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

class OrderServiceTest {

    private final OrderService orderService = new OrderService();

    @Test
    void createOrderReturnsOrderAndCanFindIt() {
        Order order = orderService.create(new CreateOrderRequest("cust-1", "prod-1", 2));

        Assertions.assertNotNull(order.id());
        Assertions.assertEquals(Optional.of(order), orderService.findById(order.id()));
    }

    @Test
    void findByIdReturnsEmptyForUnknownId() {
        Assertions.assertTrue(orderService.findById(UUID.randomUUID()).isEmpty());
    }

}
