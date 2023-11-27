package com.rentalhive.web.rest;

import com.rentalhive.repository.EquipmentItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/equipment-items")
@RequiredArgsConstructor
public class EquipmentItemRest {

    private final EquipmentItemRepository equipmentItemRepository;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(equipmentItemRepository.findAll());
    }

}
