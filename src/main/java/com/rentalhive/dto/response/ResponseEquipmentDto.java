package com.rentalhive.dto.response;

import com.rentalhive.domain.EquipmentFamily;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseEquipmentDto {
    private Long id;
    private String name;
    private Integer quantity;
    private EquipmentFamily equipmentFamily;
}
