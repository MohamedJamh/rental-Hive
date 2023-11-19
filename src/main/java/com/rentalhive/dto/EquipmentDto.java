package com.rentalhive.dto;

import com.rentalhive.domain.EquipmentFamily;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipmentDto {
    @NotNull
    private Long id;
    private String name;
    private Integer quantity;
    private EquipmentFamily equipmentFamily;
}
