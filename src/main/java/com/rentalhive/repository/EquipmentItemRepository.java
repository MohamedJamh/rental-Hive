package com.rentalhive.repository;

import com.rentalhive.domain.EquipmentItem;
import com.rentalhive.domain.OrderEquipment;
import com.rentalhive.dto.response.EquipmentResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EquipmentItemRepository extends JpaRepository<EquipmentItem, Long> {

    @Query("SELECT ei FROM EquipmentItem ei " +
            "WHERE ei.id NOT IN " +
            "(SELECT DISTINCT oe.equipmentItem.id FROM OrderEquipment oe " +
            "WHERE (:endDate < oe.order.rentStartDate OR :startDate > oe.order.rentEndDate) " +
            "AND oe.order.id NOT IN (SELECT r.offer.order.id FROM Reservation r))")
    List<EquipmentItem> findAvailableEquipmentItems(
            LocalDateTime startDate,
            LocalDateTime endDate);


    @Query("SELECT ei FROM EquipmentItem ei " +
            "WHERE ei.equipment.id = :id AND ei.id NOT IN " +
            "(SELECT DISTINCT oe.equipmentItem.id FROM OrderEquipment oe " +
            "WHERE (:endDate < oe.order.rentStartDate OR :startDate > oe.order.rentEndDate) " +
            "AND oe.order.id NOT IN (SELECT r.offer.order.id FROM Reservation r))")
    List<EquipmentItem> findAvailableEquipmentItemsByEquipmentId(Long id, LocalDateTime startDate, LocalDateTime endDate);
}
