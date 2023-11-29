package com.rentalhive.repository;

import com.rentalhive.domain.Reservation;
import com.rentalhive.dto.response.ReservationResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    @Query("SELECT new com.rentalhive.dto.response.ReservationResponseDto(ord.rentStartDate, ord.rentEndDate, off.overallCost, u.firstName, u.lastName, org.name) " +
            "FROM Reservation as r, Offer as off, Order as ord, User as u, Organization as org " +
            "WHERE r.offer.id = off.id " +
            "AND off.order.id = ord.id " +
            "AND ord.user.id = u.id " +
            "AND u.organization.id = org.id")
    List<ReservationResponseDto> getAllReservations();
}
