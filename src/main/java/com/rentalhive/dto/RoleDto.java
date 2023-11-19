package com.rentalhive.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class RoleDto {
    private Long id;
    private String name;
}
