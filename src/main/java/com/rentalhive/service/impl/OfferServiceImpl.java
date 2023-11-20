package com.rentalhive.service.impl;

import com.rentalhive.domain.Offer;
import com.rentalhive.domain.Order;
import com.rentalhive.service.OfferService;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {
    @Override
    public Offer createOffer(Order order, Double overallCost) {
        // TODO: implement logics
        throw new IllegalArgumentException("not implemented yet");
    }

    @Override
    public void acceptOffer(Offer offer) {
        // TODO: implement logics
        throw new IllegalArgumentException("not implemented yet");

    }

    @Override
    public void rejectOffer(Offer offer) {
        // TODO: implement logics
        throw new IllegalArgumentException("not implemented yet");
    }

    @Override
    public void negotiatingOffer(Offer offer) {
        // todo:

        throw new IllegalArgumentException("not implemented yet");
    }
}
