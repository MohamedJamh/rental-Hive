package com.rentalhive.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class ReservationResponseDto {
    private LocalDateTime rentStartDate;
    private LocalDateTime rentEndDate;
    private Double overallCost;
    private String firstName;
    private String lastName;
    private String organizationName;
}
