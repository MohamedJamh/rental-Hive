package com.rentalhive.mapper;

import com.rentalhive.domain.Offer;
import com.rentalhive.domain.Order;
import com.rentalhive.dto.OfferDto;
import com.rentalhive.enums.OfferStatus;

public class OfferDtoMapper {

    private OfferDtoMapper() {
    }

    public static OfferDto toDto(Offer offer) {
        return OfferDto.builder()
                .id(offer.getId())
                .orderId(offer.getOrder().getId())
                .overallCost(offer.getOverallCost())
                .negotiable(offer.getNegotiable())
                .status(offer.getStatus().name())
                .build();
    }

    public static Offer toEntity(OfferDto orderDto) {
        return Offer.builder()
                .negotiable(orderDto.getNegotiable())
                .overallCost(orderDto.getOverallCost())
                .status(OfferStatus.valueOf(orderDto.getStatus()))
                .order(
                        Order.builder()
                                .id(orderDto.getOrderId())
                                .build()
                )
                .build();
    }
}
