package com.rentalhive.mapper;

import com.rentalhive.domain.Order;
import com.rentalhive.dto.OrderDto;

public class OrderDtoMapper {

    private OrderDtoMapper() {
    }

    public static OrderDto toDto(Order order) {
        return OrderDto.builder()

                .build();
    }
    public static Order toEntity(OrderDto orderDto) {
        return Order.builder()
                .build();
    }
}
