package com.rentalhive.web.rest;

import com.rentalhive.domain.Order;
import com.rentalhive.dto.OrderDto;
import com.rentalhive.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderDto orderRequest) {
        // Implement request validation and call orderService.createOrder
        throw new IllegalArgumentException("not implemented yet");
    }
}