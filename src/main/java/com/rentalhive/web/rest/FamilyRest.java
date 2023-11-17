package com.rentalhive.web.rest;

import com.rentalhive.domain.Equipment;
import com.rentalhive.domain.EquipmentFamily;
import com.rentalhive.dto.EquipmentDto;
import com.rentalhive.dto.FamilyDto;
import com.rentalhive.mapper.EquipmentDtoMapper;
import com.rentalhive.mapper.FamilyDtoMapper;
import com.rentalhive.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/equipment-family")
public class FamilyRest {
    private final FamilyService familyService;

    @Autowired
    public FamilyRest(FamilyService familyService) {
        this.familyService = familyService;
    }

    @PostMapping("/save")
    public EquipmentFamily addFamily(@Valid @RequestBody FamilyDto familyDto){
        EquipmentFamily equipmentFamily = FamilyDtoMapper.toFamily(familyDto);
        return familyService.save(equipmentFamily);
    }

    @PutMapping("/update")
    public EquipmentFamily updateFamily(@Valid @RequestBody FamilyDto familyDto){
        EquipmentFamily equipmentFamily = FamilyDtoMapper.toFamily(familyDto);
        return familyService.save(equipmentFamily);
    }

    @GetMapping("/")
    public List<EquipmentFamily> findAll(){
        return familyService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try {
            familyService.delete(id);
            return ResponseEntity.ok("EquipmentFamily a été supprimé avec success");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la suppression !");        }
    }

}
