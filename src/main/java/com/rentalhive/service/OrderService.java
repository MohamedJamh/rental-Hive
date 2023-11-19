package com.rentalhive.service;

import com.rentalhive.domain.Order;
import com.rentalhive.dto.OrderDto;
import com.rentalhive.dto.response.OrderResponseDto;

public interface OrderService {
    OrderResponseDto createOrder(OrderDto orderRequestDto);
}
