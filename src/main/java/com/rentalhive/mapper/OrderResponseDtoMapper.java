package com.rentalhive.mapper;

import com.rentalhive.domain.Order;
import com.rentalhive.dto.OrderDto;
import com.rentalhive.dto.request.EquipmentRequestDTO;
import com.rentalhive.dto.response.OrderResponseDto;

import java.util.List;

public class OrderResponseDtoMapper {

    private OrderResponseDtoMapper() {
    }

    public static OrderResponseDto toDto(Order order) {
        return OrderResponseDto.builder()
                .end(order.getRentEndDate())
                .start(order.getRentStartDate())
                .build();
    }
    public static Order toEntity(OrderResponseDto orderDto) {
        return Order.builder()
                .rentStartDate(orderDto.getStart())
                .rentEndDate(orderDto.getEnd())
                .build();
    }
}
