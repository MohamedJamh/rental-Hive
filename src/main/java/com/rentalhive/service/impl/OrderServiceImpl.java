package com.rentalhive.service.impl;

import com.rentalhive.domain.EquipmentItem;
import com.rentalhive.domain.Order;
import com.rentalhive.repository.OrderRepository;
import com.rentalhive.service.OrderService;
import com.rentalhive.web.rest.httpDto.OrderRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    @Override
    public Order createOrder(OrderRequestDto orderRequestDto) {
        LocalDateTime end = orderRequestDto.getEnd();
        LocalDateTime start = orderRequestDto.getStart();
        List<EquipmentItem> equipmentItems = orderRequestDto.getEquipmentItems();
        if(equipmentItems.isEmpty())
            throw new IllegalArgumentException("No equipment is selected");
        if(end.isBefore(start))
            throw new IllegalArgumentException("Date start should be before date end");


        return null;
    }
}
