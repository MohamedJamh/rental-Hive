package com.rentalhive.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfferDto {
    private Long id;

    @NotNull(message = "OverallCost is required")
    @Min(value = 0, message = "OverallCost must be greater than 0")
    private Double overallCost;

    private String status;

    @NotNull(message = "Negotiable field is required")
    private Boolean negotiable;

    @NotNull(message = "order is required")
    private Long orderId;
}
