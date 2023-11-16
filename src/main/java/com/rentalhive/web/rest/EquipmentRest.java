package com.rentalhive.web.rest;

import com.rentalhive.domain.Equipment;
import com.rentalhive.dto.EquipmentDto;
import com.rentalhive.mapper.EquipmentDtoMapper;
import com.rentalhive.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/equipments")
public class EquipmentRest {
    private final EquipmentService equipmentService;

    @Autowired
    public EquipmentRest(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("/")
    public List<Equipment> getAllEquipments(){
        return equipmentService.findAll();
    }

    @PostMapping("/save")
    public Equipment addEquipment(@Valid @RequestBody EquipmentDto equipmentDto){
        Equipment equipment = EquipmentDtoMapper.toEquipment(equipmentDto);
        return equipmentService.save(equipment);
    }
}
