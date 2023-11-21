package com.rentalhive.repository;

import com.rentalhive.domain.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

import java.util.Optional;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    //find by id
    public Optional<Equipment> findById(long id);


//TODO:
//    @Query("select e, count(ei) as quantityAvailable" +
//            "SELECT ei FROM EquipmentItem ei " +
//            "WHERE ei.id NOT IN " +
//            "(SELECT DISTINCT oe.equipmentItem.id FROM OrderEquipment oe " +
//            "WHERE (:endDate < oe.order.rentStartDate OR :startDate > oe.order.rentEndDate) " +
//            "AND oe.order.id NOT IN (SELECT r.offer.order.id FROM Reservation r))")
//    List<EquipmentResponseDTO> findAvailableEquipment(LocalDateTime startDate, LocalDateTime endDate);
}
