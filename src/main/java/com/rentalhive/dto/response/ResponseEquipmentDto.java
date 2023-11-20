package com.rentalhive.dto.response;

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
public class ResponseEquipmentDto {
    @NotNull
    private Long id;
    private String name;
    private Integer quantity;
    private EquipmentFamily equipmentFamily;
}
