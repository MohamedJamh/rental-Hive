package com.rentalhive.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipmentRequestDTO {
    @NotNull
    private Long id;
    private String name;
    @NotNull
    private Integer quantityReserved;
}
