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
    @NotBlank(message = "Name cannot be blank")
    @NotNull(message = "Name cannot be null")
    private String modelName;
    @NotNull(message = "Model type reference cannot be null")
    private Long modelId;
    @NotNull(message = "image cannot be null")
    @NotBlank(message = "image cannot be blank")
    private String classpath;
}
