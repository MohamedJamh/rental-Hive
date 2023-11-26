package com.rentalhive.repository;

import com.rentalhive.domain.OrderEquipment;
import com.rentalhive.domain.embedded.OrderEquipmentId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderEquipmentRepository extends JpaRepository<OrderEquipment, OrderEquipmentId> {
    public List<OrderEquipment> getOrderEquipmentByOrderId(Long orderId);
}
