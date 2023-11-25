package com.rentalhive.web.rest;

import com.rentalhive.dto.OrderDto;
import com.rentalhive.dto.response.OrderResponseDto;
import com.rentalhive.exception.QuantityExceededException;
import com.rentalhive.service.OrderService;
import com.rentalhive.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<?> finAll() {
        return ResponseEntity.ok().body(
                Response.builder()
                        .message("fetching all orders")
                        .result(orderService.findAll())
                        .build()
        );
    }


    @PostMapping
    public ResponseEntity<Response<OrderResponseDto>> createOrder(@RequestBody OrderDto orderRequest) throws QuantityExceededException {
        OrderResponseDto orderSaved = orderService.createOrder(orderRequest);
        Response<OrderResponseDto> body = new Response<>();
        body.setResult(orderSaved);
        body.setMessage("Order has been saved successfully");
        return ResponseEntity.ok(body);
    }
}