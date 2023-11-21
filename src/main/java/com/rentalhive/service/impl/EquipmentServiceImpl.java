package com.rentalhive.service.impl;

import com.rentalhive.domain.Equipment;
import com.rentalhive.repository.EquipmentRepository;
import com.rentalhive.service.EquipmentService;
import com.rentalhive.utils.CustomError;
import com.rentalhive.utils.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository equipmentRepository;

    @Autowired
    public EquipmentServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public Equipment save(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    @Override
    public Equipment update(Equipment equipment) throws ValidationException {
        Optional<Equipment> equipmentOptional = equipmentRepository.findById(equipment.getId());
        if(equipmentOptional.isEmpty())
            throw new ValidationException( new CustomError("id","Equipment doesn't exist"));
        if(equipment.getQuantity() < equipmentOptional.get().getQuantity())
            throw new RuntimeException("Quantity can't be less than the previous one");
        return equipmentRepository.save(equipment);
    }

    @Override
    public List<Equipment> findAll() {
        return equipmentRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        equipmentRepository.deleteById(id);
    }

    @Override
    public Optional<Equipment> findById(Long id) {
        return equipmentRepository.findById(id);
    }

    @Override
    public void deleteAll() {
        equipmentRepository.deleteAll();
    }
}
