package com.rentalhive.mapper;

import com.rentalhive.domain.OrderEquipment;
import com.rentalhive.dto.response.OrderEquipmentResponseDto;

public class OrderEquipmentItemResponseDtoMapper {

    public static OrderEquipmentResponseDto toDto(OrderEquipment equipmentItem) {
            return OrderEquipmentResponseDto.builder()
                    .id(equipmentItem.getId())
                    .price(equipmentItem.getRentPrice())
                    .equipmentName(equipmentItem.getEquipmentItem().getEquipment().getName())
                    .reference(equipmentItem.getEquipmentItem().getReference())
                    .build();
    }
}
