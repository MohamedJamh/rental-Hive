package com.rentalhive.mapper;

import com.rentalhive.domain.Order;
import com.rentalhive.domain.OrderEquipment;
import com.rentalhive.dto.OrderDto;
import com.rentalhive.dto.request.EquipmentRequestDTO;

import java.util.List;

public class OrderDtoMapper {

    private OrderDtoMapper() {
    }

    public static OrderDto toDto(Order order) {
        return OrderDto.builder()
                .end(order.getRentEndDate())
                .start(order.getRentStartDate())
                .build();
    }
    public static Order toEntity(OrderDto orderDto) {
        return Order.builder()
                .rentStartDate(orderDto.getStart())
                .rentEndDate(orderDto.getEnd())
                .build();
    }
}
