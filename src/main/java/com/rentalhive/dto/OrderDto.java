package com.rentalhive.dto;

import com.rentalhive.domain.Location;
import com.rentalhive.dto.request.EquipmentRequestDTO;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {

    @NotNull
    List<EquipmentRequestDTO> equipments;
    @DateTimeFormat
    @NotNull
    LocalDateTime start;
    @DateTimeFormat
    @NotNull
    LocalDateTime end;
    @DateTimeFormat
    @Nullable
    Location location;
}