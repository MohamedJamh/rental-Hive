package com.rentalhive.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestEquipmentDto {
    private Long id;

    @NotNull(message = "name cannot be null")
    @NotBlank(message = "name cannot be blank")
    private String name;

    @Min(value = 0, message = "Quantity must be greater than or equal to {value}")
    @NotNull(message = "quantity cannot be null")
    private Integer quantity;

    private Long equipmentFamilyId;
}
