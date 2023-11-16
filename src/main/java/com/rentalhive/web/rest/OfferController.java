package com.rentalhive.web.rest;

import com.rentalhive.domain.Offer;
import com.rentalhive.service.OfferService;
import com.rentalhive.web.rest.httpDto.OfferRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/offers")
@RequiredArgsConstructor
public class OfferController {
    private final OfferService offerService;

    @PostMapping("/create")
    public ResponseEntity<Offer> createOffer(@RequestBody OfferRequestDto offerRequestDto) {
        // TODO: implement logics
        // Parse and validate input, then call offerService.createOffer
        // Return ResponseEntity with appropriate status code
        throw new IllegalArgumentException("not implemented yet");
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
