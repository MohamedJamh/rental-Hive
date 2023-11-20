package com.rentalhive.dto.request;

import com.rentalhive.domain.EquipmentFamily;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestEquipmentDto {
    private Long id;
    private String name;
    private Integer quantity;
    private Long equipmentFamily_id;
}
