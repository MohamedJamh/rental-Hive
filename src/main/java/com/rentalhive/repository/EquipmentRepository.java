package com.rentalhive.repository;

import com.rentalhive.domain.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    //find by id
    public Optional<Equipment> findById(long id);

    Optional<Equipment> findByName(String name);
}
