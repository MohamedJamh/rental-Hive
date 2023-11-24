package com.rentalhive.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EdocumentDto {
    @NotBlank
    @NotNull
    private String model_name;
    @NotNull
    private Long model_id;
    @NotBlank
    @NotNull
    private String classpath;
}
