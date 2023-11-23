package com.rentalhive.service.impl;

import com.rentalhive.domain.Offer;
import com.rentalhive.enums.OfferStatus;
import com.rentalhive.repository.OfferRepository;
import com.rentalhive.repository.OrderRepository;
import com.rentalhive.service.OfferService;
import com.rentalhive.utils.CustomError;
import com.rentalhive.utils.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final OrderRepository orderRepository;
    @Override
    public List<Offer> getOffersByStatusOrStatus(OfferStatus status, OfferStatus status2) {
        return offerRepository.findAllByStatusOrStatus(status, status2);
    }

    @Override
    public Offer createOffer(Offer offer) throws ValidationException {
        if(orderRepository.findById(offer.getOrder().getId()).isEmpty())
            throw new ValidationException(
                    new CustomError("Order reference","Order does not exist")
            );
        if(offerRepository.getByOrderIdAndAndStatus(offer.getOrder().getId(),OfferStatus.PENDING).isPresent())
            throw new ValidationException(
                    new CustomError("Order reference","There is already a pending offer for this order")
            );
        return offerRepository.save(offer);
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
