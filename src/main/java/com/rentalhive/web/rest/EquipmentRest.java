package com.rentalhive.web.rest;

import com.rentalhive.domain.Equipment;
import com.rentalhive.domain.EquipmentFamily;
import com.rentalhive.dto.EquipmentDto;
import com.rentalhive.dto.response.EquipmentResponseDTO;
import com.rentalhive.mapper.EquipmentDtoMapper;
import com.rentalhive.service.EquipmentService;
import com.rentalhive.service.FamilyService;
import com.rentalhive.utils.ValidationException;
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
    public ResponseEntity<Equipment> addEquipment(@Valid @RequestBody EquipmentDto equipmentDto){
        try{
            Equipment equipment = EquipmentDtoMapper.toEquipment(equipmentDto);
            EquipmentFamily family = familyService.findById(equipmentDto.getEquipmentFamilyId()).orElseThrow();
            equipment.setEquipmentFamily(family);
            return new ResponseEntity<>(equipmentService.save(equipment),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<EquipmentDto>> updateEquipment(@Valid @RequestBody EquipmentDto equipmentDto, @PathVariable Long id){
        Response<EquipmentDto> response = new Response<>();
        Equipment equipment = EquipmentDtoMapper.toEquipment(equipmentDto);
        equipment.setId(id);
        try {
            response.setResult(EquipmentDtoMapper.toDto(equipmentService.update(equipment)));
            response.setMessage("Equipment has been updated successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (ValidationException ex){
            response.setMessage("Equipment has not been updated");
            response.setErrors(List.of(ex.getCustomError()));
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        try {
            equipmentService.delete(id);
            String message = "Equipment a été supprimé avec success";
            return ResponseEntity.ok(message);
        }catch (Exception e) {
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
