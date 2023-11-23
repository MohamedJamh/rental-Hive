package com.rentalhive.web.rest;

import com.rentalhive.domain.Offer;
import com.rentalhive.dto.OfferDto;
import com.rentalhive.enums.OfferStatus;
import com.rentalhive.mapper.OfferDtoMapper;
import com.rentalhive.service.OfferService;
import com.rentalhive.utils.Response;
import com.rentalhive.utils.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/offer")
@RequiredArgsConstructor
public class OfferController {
    private final OfferService offerService;
    @GetMapping
    public ResponseEntity<Response<List<OfferDto>>> getCurrentOffers(){
        Response<List<OfferDto>> response = getOffersByStatusOrStatus(OfferStatus.PENDING, OfferStatus.NEGOTIATING);
        if(response.getResult().isEmpty())
            response.setMessage("No offers found at the moment");
        return ResponseEntity.ok().body(response);
    }
    @GetMapping("/history")
    public ResponseEntity<Response<List<OfferDto>>> getOffersHistory(){
        Response<List<OfferDto>> response = getOffersByStatusOrStatus(OfferStatus.FULFILLED, OfferStatus.REJECTED);
        if(response.getResult().isEmpty())
            response.setMessage("There is no offers history at the moment");
        return ResponseEntity.ok().body(response);
    }
    private Response<List<OfferDto>> getOffersByStatusOrStatus(OfferStatus status, OfferStatus status2) {
        Response<List<OfferDto>> response = new Response<>();
        List<OfferDto> offers = new ArrayList<>();
        offerService.getOffersByStatusOrStatus(status, status2)
                .stream().map(OfferDtoMapper::toDto)
                .forEach(offers::add);
        response.setResult(offers);
        return response;
    }
    @PostMapping
    public ResponseEntity<Response<OfferDto>> createOffer(@RequestBody @Valid OfferDto offerRequestDto) {
        Response<OfferDto> response = new Response<>();
        offerRequestDto.setStatus(OfferStatus.PENDING.toString());
        Offer offer = OfferDtoMapper.toEntity(offerRequestDto);
        try {
            OfferDto offerDto = OfferDtoMapper.toDto(offerService.createOffer(offer));
            response.setResult(offerDto);
            response.setMessage("Offer created successfully");
            return ResponseEntity.ok().body(response);
        } catch (ValidationException e) {
            response.setMessage("Offer has not been created");
            response.setErrors(List.of(e.getCustomError()));
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/accept/{offerId}")
    public ResponseEntity<Void> acceptOffer(@PathVariable Long offerId) {
        // TODO: implement logics
        // Call offerService.acceptOffer and return ResponseEntity with appropriate status code
        throw new IllegalArgumentException("not implemented yet");
    }

    @PostMapping("/reject/{offerId}")
    public ResponseEntity<Void> rejectOffer(@PathVariable Long offerId) {
        // TODO: implement logics
        // Call offerService.rejectOffer and return ResponseEntity with appropriate status code
        throw new IllegalArgumentException("not implemented yet");
    }
}
