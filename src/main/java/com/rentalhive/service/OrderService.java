package com.rentalhive.service;

import com.rentalhive.domain.Order;
import com.rentalhive.web.rest.httpDto.OrderRequestDto;

public interface OrderService {
    Order createOrder(OrderRequestDto orderRequestDto);
}
