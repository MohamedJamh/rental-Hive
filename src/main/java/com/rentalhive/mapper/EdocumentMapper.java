package com.rentalhive.mapper;

import com.rentalhive.domain.Edocument;
import com.rentalhive.dto.EdocumentDto;

public class EdocumentMapper {
    public EdocumentMapper() {
    }
    public static EdocumentDto toDto(Edocument edocument)
    {
        return EdocumentDto.builder().model_id(edocument.getModel_id()).model_name(edocument.getModel_name()).classpath(edocument.getClasspath()).build();
    }

    public static Edocument toEdocument(EdocumentDto edocumentDto)
    {
        return Edocument.builder().model_name(edocumentDto.getModel_name()).model_id(edocumentDto.getModel_id()).classpath(edocumentDto.getClasspath()).build();
    }
}
