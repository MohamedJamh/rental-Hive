package com.rentalhive.service;

import com.rentalhive.dto.OrderDto;
import com.rentalhive.dto.response.OrderResponseDto;
import com.rentalhive.exception.QuantityExceededException;

public interface OrderService {
    OrderResponseDto createOrder(OrderDto orderRequestDto) throws QuantityExceededException;
}
