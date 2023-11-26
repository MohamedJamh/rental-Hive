package com.rentalhive.service.impl;

import com.rentalhive.domain.Equipment;
import com.rentalhive.domain.EquipmentFamily;
import com.rentalhive.repository.EquipmentRepository;
import com.rentalhive.repository.FamilyRepository;
import com.rentalhive.service.EquipmentService;
import com.rentalhive.utils.CustomError;
import com.rentalhive.utils.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final FamilyRepository familyRepository;


    @Override
    public Equipment save(Equipment equipment) throws ValidationException {
        Optional<EquipmentFamily> optionalEquipmentFamily = familyRepository.findById(equipment.getEquipmentFamily().getId());
        if(optionalEquipmentFamily.isEmpty())
            throw new ValidationException(new CustomError("Equipment family","Equipment family does not exist"));
        Optional<Equipment> optionalEquipment = equipmentRepository.findByName(equipment.getName());
        if(optionalEquipment.isPresent())
            throw new ValidationException(new CustomError("Equipment name","Equipment name already exists"));
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
