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
public class EquipmentRequestDTO {
    private Long id;
    private String name;
    private Integer quantityReserved;
}
