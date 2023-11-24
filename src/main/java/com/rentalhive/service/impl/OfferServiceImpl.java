package com.rentalhive.service.impl;

import com.rentalhive.domain.Offer;
import com.rentalhive.domain.User;
import com.rentalhive.enums.OfferStatus;
import com.rentalhive.repository.OfferRepository;
import com.rentalhive.repository.OrderRepository;
import com.rentalhive.service.OfferService;
import com.rentalhive.utils.CustomError;
import com.rentalhive.utils.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final OrderRepository orderRepository;
    private final User userConnected;

    public Offer getOfferIfExist(Long id) throws ValidationException {
        Optional<Offer> offerOptional = offerRepository.findById(id);
        if(offerOptional.isEmpty())
            throw new ValidationException(
                    new CustomError("Offer reference","Offer does not exist")
            );
        return offerOptional.get();
    }
    @Override
    public List<Offer> getOffersByStatusOrStatus(OfferStatus status, OfferStatus status2) {
        return offerRepository.findAllByStatusOrStatus(status, status2);
    }

    @Override
    public Offer createOffer(Offer offer) throws ValidationException {
        if(offerRepository.getByOrderIdAndAndStatus(offer.getOrder().getId(),OfferStatus.PENDING).isPresent())
            throw new ValidationException(
                    new CustomError("Order reference","There is already a pending offer for this order")
            );
        return offerRepository.save(offer);
    }

    @Override
    public Offer acceptOffer(Long id) throws ValidationException {
        Offer offer = getOfferIfExist(id);
        offerBelongsToUser(offer);
        if( ! List.of(OfferStatus.PENDING, OfferStatus.NEGOTIATING).contains(offer.getStatus()))
            invalidAction();
        offer.setStatus(OfferStatus.FULFILLED);
        return offerRepository.save(offer);
    }

    @Override
    public Offer rejectOffer(Long id) throws ValidationException {
        Offer offer = getOfferIfExist(id);
        offerBelongsToUser(offer);
        if( ! List.of(OfferStatus.PENDING, OfferStatus.NEGOTIATING).contains(offer.getStatus()))
            invalidAction();
        offer.setStatus(OfferStatus.REJECTED);
        return offerRepository.save(offer);
    }

    @Override
    public Offer negotiatingOffer(Long id) throws ValidationException{
        Offer offer = getOfferIfExist(id);
        offerBelongsToUser(offer);
        if( ! OfferStatus.PENDING.equals(offer.getStatus()))
            invalidAction();
        if(Boolean.FALSE.equals( offer.getNegotiable()))
            throw new ValidationException(
                    new CustomError("Offer negotiable","This offer is not negotiable")
            );
        offer.setStatus(OfferStatus.NEGOTIATING);
        return offerRepository.save(offer);
    }

    private void invalidAction() throws ValidationException {
        throw new ValidationException(
                new CustomError("Offer status","Please submit a valid action on this offer")
        );
    }

    private void offerBelongsToUser(Offer offer) throws ValidationException {
        if( ! userConnected.equals(offer.getOrder().getUser()))
            throw new ValidationException(
                new CustomError("Offer reference","This offer does not belong to you")
            );
    }

}
