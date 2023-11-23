package com.rentalhive.service;

import com.rentalhive.domain.Offer;
import com.rentalhive.enums.OfferStatus;
import com.rentalhive.utils.ValidationException;

import java.util.List;

public interface OfferService {
    List<Offer> getOffersByStatusOrStatus(OfferStatus status, OfferStatus status2);
    Offer createOffer(Offer offer) throws ValidationException;
    void acceptOffer(Offer offer);
    void rejectOffer(Offer offer);

    void negotiatingOffer(Offer offer);
}
