package com.rentalhive.mapper;

import com.rentalhive.domain.Equipment;
import com.rentalhive.domain.EquipmentFamily;
import com.rentalhive.dto.request.RequestEquipmentDto;
import com.rentalhive.dto.response.ResponseEquipmentDto;

public class EquipmentDtoMapper {

    private EquipmentDtoMapper(){
    }

    public static ResponseEquipmentDto toDto(Equipment equipment){
        return ResponseEquipmentDto.builder()
                .id(equipment.getId())
                .name(equipment.getName())
                .quantity(equipment.getQuantity())
                .equipmentFamily(equipment.getEquipmentFamily())
                .build();
    }


    public static Equipment toEquipment(RequestEquipmentDto equipmentDto){

        return Equipment.builder()
                .id(equipmentDto.getId())
                .name(equipmentDto.getName())
                .quantity(equipmentDto.getQuantity())
                .build();
    }
}
