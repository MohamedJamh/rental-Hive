package com.rentalhive.service;

import com.rentalhive.domain.Order;
import com.rentalhive.dto.OrderDto;
import com.rentalhive.dto.response.OrderResponseDto;
import com.rentalhive.exception.QuantityExceededException;

import java.util.List;

public interface OrderService {
    OrderResponseDto createOrder(OrderDto orderRequestDto) throws QuantityExceededException;

    List<Order> findAll();
}
