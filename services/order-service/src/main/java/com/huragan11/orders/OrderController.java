package com.huragan11.orders;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.validation.Valid;

import java.util.Optional;
import java.util.UUID;

@Controller("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Post
    public HttpResponse<Order> create(@Valid @Body CreateOrderRequest request) {
        return HttpResponse.created(orderService.create(request));
    }

    @Get("/{id}")
    public Optional<Order> findById(UUID id) {
        return orderService.findById(id);
    }
}
