package com.rentalhive.web.rest;

import com.rentalhive.domain.Equipment;
import com.rentalhive.dto.EquipmentDto;
import com.rentalhive.mapper.EquipmentDtoMapper;
import com.rentalhive.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/update")
    public Equipment updateEquipment(@Valid @RequestBody EquipmentDto equipmentDto){
        Equipment equipment = EquipmentDtoMapper.toEquipment(equipmentDto);
        return equipmentService.save(equipment);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        try {
            equipmentService.delete(id);
            String message = "Equipment a été supprimé avec success";
            return ResponseEntity.ok(message);
        } catch (Exception e) {
            String errorMessage = "Erreur lors de la suppression !";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorMessage);
        }
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllBooks() {
        try {
            equipmentService.deleteAll();
            String message = "Equipments sont supprimés avec success";
            return ResponseEntity.ok(message);
        } catch (Exception e) {
            String errorMessage = "Erreur lors de la suppression !";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorMessage);
        }
    }
}
