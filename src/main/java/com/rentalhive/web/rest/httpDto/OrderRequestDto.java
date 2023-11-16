package com.rentalhive.web.rest.httpDto;

import com.rentalhive.domain.Equipment;
import com.rentalhive.domain.EquipmentItem;
import com.rentalhive.domain.Location;
import com.sun.istack.NotNull;
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
public class OrderRequestDto {

    @NotNull
    List<EquipmentItem> equipmentItems;
    @DateTimeFormat
    @NotNull
    LocalDateTime start;
    @DateTimeFormat
    @NotNull
    LocalDateTime end;
    @DateTimeFormat
    @NotNull
    Location location;
}
