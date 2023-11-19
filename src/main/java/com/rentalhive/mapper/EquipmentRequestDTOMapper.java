package com.rentalhive.mapper;

import com.rentalhive.domain.Equipment;
import com.rentalhive.dto.EquipmentDto;
import com.rentalhive.dto.request.EquipmentRequestDTO;

public class EquipmentRequestDTOMapper {
    private EquipmentRequestDTOMapper(){
    }

    public static EquipmentRequestDTO toDto(Equipment equipment, Integer quantityReserved){
        return EquipmentRequestDTO.builder()
                .id(equipment.getId())
                .name(equipment.getName())
                .quantityReserved(quantityReserved)
                .build();
    }

    public static Equipment toEquipment(EquipmentRequestDTO equipmentDto){
        return Equipment.builder()
                .id(equipmentDto.getId())
                .name(equipmentDto.getName())
                .build();
    }
}
