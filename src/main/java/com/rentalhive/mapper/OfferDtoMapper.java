package com.rentalhive.mapper;

import com.rentalhive.domain.Offer;
import com.rentalhive.dto.OfferDto;

public class OfferDtoMapper {

    private OfferDtoMapper() {
    }

    public static OfferDto toDto(Offer order) {
        return OfferDto.builder()
                .build();
    }

    public static Offer toEntity(OfferDto orderDto) {
        return Offer.builder().build();
    }
}
