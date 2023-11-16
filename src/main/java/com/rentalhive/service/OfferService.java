package com.rentalhive.service;

import com.rentalhive.domain.Offer;
import com.rentalhive.domain.Order;

public interface OfferService {

    Offer createOffer(Order order, Double overallCost);
    void acceptOffer(Offer offer);
    void rejectOffer(Offer offer);

    void negotiatingOffer(Offer offer);
}
