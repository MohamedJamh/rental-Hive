package com.rentalhive.service;

import com.rentalhive.domain.Order;
import com.rentalhive.dto.OrderDto;

public interface OrderService {
    Order createOrder(OrderDto orderRequestDto);
}
