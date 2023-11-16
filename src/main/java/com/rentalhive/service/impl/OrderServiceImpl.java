package com.rentalhive.service.impl;

import com.rentalhive.domain.EquipmentItem;
import com.rentalhive.domain.Order;
import com.rentalhive.domain.OrderEquipment;
import com.rentalhive.dto.OrderDto;
import com.rentalhive.mapper.OrderDtoMapper;
import com.rentalhive.repository.OrderEquipmentRepository;
import com.rentalhive.repository.OrderRepository;
import com.rentalhive.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderEquipmentRepository orderEquipmentRepository;

    @Override
    @Transactional
    public Order createOrder(OrderDto orderRequestDto) {
        List<EquipmentItem> equipmentItems = orderRequestDto.getEquipmentItems();
        final List<OrderEquipment> orderEquipment = new ArrayList<>();
        if(equipmentItems.isEmpty())
            throw new IllegalArgumentException("No equipment is selected");
        if(orderRequestDto.getEnd()
                .isBefore(orderRequestDto.getStart()))
            throw new IllegalArgumentException("Date start should be before date end");
        Order order = OrderDtoMapper.toEntity(orderRequestDto);
        equipmentItems.forEach(equipmentItem ->
                orderEquipment.add(OrderEquipment.builder()
                        .equipmentItem(equipmentItem)
                        .order(order)
                        .build()));
        order.setOrderEquipments(orderEquipment);
        return orderRepository.save(order);
    }
}
