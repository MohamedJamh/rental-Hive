package com.rentalhive.web.rest;

import com.rentalhive.domain.Equipment;
import com.rentalhive.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/equipments")
public class EquipmentRest {
    private final EquipmentService equipmentService;

    @Autowired
    public EquipmentRest(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("")
    public List<Equipment> getAllEquipments(){
        return equipmentService.findAll();
    }
}
