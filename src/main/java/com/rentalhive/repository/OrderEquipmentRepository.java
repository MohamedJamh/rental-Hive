package com.rentalhive.repository;

import com.rentalhive.domain.OrderEquipment;
import com.rentalhive.domain.embedded.OrderEquipmentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderEquipmentRepository extends JpaRepository<OrderEquipment, OrderEquipmentId> {
}
