package com.rentalhive.service;

import com.rentalhive.domain.EquipmentFamily;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FamilyService {
    public EquipmentFamily save(EquipmentFamily equipmentFamily);
    public List<EquipmentFamily> findAll();
    public Optional<EquipmentFamily> findById(Long id);
    public EquipmentFamily update(EquipmentFamily equipmentFamily);
    public void delete(Long id);

}
