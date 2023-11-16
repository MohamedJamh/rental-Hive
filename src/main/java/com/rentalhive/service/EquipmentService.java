package com.rentalhive.service;

import com.rentalhive.domain.Equipment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EquipmentService {
    public Equipment save(Equipment equipment);
    public Equipment update(Equipment equipment);
    public List<Equipment> findAll();
    public void delete(Long id);
    public Optional<Equipment> findById(Long id);
}
