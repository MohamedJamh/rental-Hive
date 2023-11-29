package com.rentalhive.web.rest;

import com.rentalhive.dto.response.ReservationResponseDto;
import com.rentalhive.service.impl.ReservationServiceImpl;
import com.rentalhive.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservation")
@RequiredArgsConstructor
public class ReservationRest {
    private final ReservationServiceImpl reservationService;
    @GetMapping
    public ResponseEntity<Response<List<ReservationResponseDto>>> getAllReservations() {
        Response<List<ReservationResponseDto>> response = new Response<>();
        List<ReservationResponseDto> reservations = reservationService.getAllReservations();
        if(reservations.isEmpty())
            response.setMessage("No reservations found");
        else
            response.setMessage("All reservations");
        response.setResult(reservations);
        return ResponseEntity.ok().body(response);
    }
}
