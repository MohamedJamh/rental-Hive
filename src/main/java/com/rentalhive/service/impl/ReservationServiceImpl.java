package com.rentalhive.service.impl;

import com.rentalhive.dto.response.ReservationResponseDto;
import com.rentalhive.repository.ReservationRepository;
import com.rentalhive.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    public List<ReservationResponseDto> getAllReservations() {
        return reservationRepository.getAllReservations();
    }
}
