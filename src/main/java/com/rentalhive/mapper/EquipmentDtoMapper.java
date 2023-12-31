package com.rentalhive.mapper;

import com.rentalhive.domain.Equipment;
import com.rentalhive.domain.EquipmentFamily;
import com.rentalhive.dto.EquipmentDto;

public class EquipmentDtoMapper {

    private EquipmentDtoMapper(){
    }

    public static EquipmentDto toDto(Equipment equipment){
        return EquipmentDto.builder()
                .id(equipment.getId())
                .name(equipment.getName())
                .quantity(equipment.getQuantity())
                .equipmentFamily(
                        EquipmentFamily.builder()
                                .id(equipment.getEquipmentFamily().getId())
                                .build()
                )
                .build();
    }


    public static Equipment toEquipment(EquipmentDto equipmentDto){

        return Equipment.builder()
                .id(equipmentDto.getId())
                .name(equipmentDto.getName())
                .quantity(equipmentDto.getQuantity())
                .equipmentFamily(
                        EquipmentFamily.builder()
                                .id(equipmentDto.getEquipmentFamily().getId())
                                .build()
                )
                .build();
    }
}
