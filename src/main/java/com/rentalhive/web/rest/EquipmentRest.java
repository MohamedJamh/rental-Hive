package com.rentalhive.web.rest;

import com.rentalhive.domain.Equipment;
import com.rentalhive.domain.EquipmentFamily;
import com.rentalhive.dto.request.RequestEquipmentDto;
import com.rentalhive.dto.response.EquipmentResponseDTO;
import com.rentalhive.mapper.EquipmentDtoMapper;
import com.rentalhive.service.EquipmentService;
import com.rentalhive.service.FamilyService;
import lombok.RequiredArgsConstructor;
import com.rentalhive.service.impl.EquipmentItemServiceImpl;
import com.rentalhive.utils.Response;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/equipment")
@RequiredArgsConstructor
public class EquipmentRest {

    private final EquipmentService equipmentService;
    private final FamilyService familyService;
    private final EquipmentItemServiceImpl equipmentItemService;

    @GetMapping()
    public List<Equipment> getAllEquipments(){
        return equipmentService.findAll();
    }

    @PostMapping()
    public ResponseEntity<Equipment> addEquipment(@Valid @RequestBody RequestEquipmentDto requestEquipmentDto){
        try{
            Equipment equipment = EquipmentDtoMapper.toEquipment(requestEquipmentDto);
            EquipmentFamily family = familyService.findById(requestEquipmentDto.getEquipmentFamilyId()).orElseThrow();
            equipment.setEquipmentFamily(family);
            return new ResponseEntity<>(equipmentService.save(equipment),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipment> updateEquipment(@Valid @PathVariable("id") long id, @RequestBody RequestEquipmentDto requestEquipmentDto){
        try{
            Optional<Equipment> eq = equipmentService.findById(id);
            if(eq.isPresent()){
                Equipment equipment = EquipmentDtoMapper.toEquipment(requestEquipmentDto);
                equipment.setId(id);
                EquipmentFamily family = familyService.findById(requestEquipmentDto.getEquipmentFamilyId()).orElseThrow();
                equipment.setEquipmentFamily(family);
                return new ResponseEntity<>(equipmentService.save(equipment),HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
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

    @GetMapping("/available")
    public ResponseEntity<Response<List<EquipmentResponseDTO>>> getEquipmentAvailable(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end
    ) {
        Response<List<EquipmentResponseDTO>> response = new Response<>();
        response.setMessage("Retrieve equipment is successful");
        response.setResult(equipmentItemService.findAvailableEquipments(start, end));
        return ResponseEntity.ok().body(response);
    }
}
