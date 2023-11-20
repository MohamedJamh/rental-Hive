package com.rentalhive.service.impl;

import com.rentalhive.domain.Equipment;
import com.rentalhive.domain.EquipmentItem;
import com.rentalhive.dto.response.EquipmentResponseDTO;
import com.rentalhive.repository.EquipmentItemRepository;
import com.rentalhive.repository.EquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EquipmentItemServiceImpl {

    private final EquipmentItemRepository repository;
    private final EquipmentRepository equipmentRepository;

    public List<EquipmentItem> findAvailableEquipmentItems(LocalDateTime startDate, LocalDateTime endDate) {
        return repository.findAvailableEquipmentItems(startDate, endDate);
    }

    public List<EquipmentResponseDTO> findAvailableEquipments(LocalDateTime startDate, LocalDateTime endDate) {
        List<EquipmentItem> availableEquipmentItems = findAvailableEquipmentItems(startDate, endDate);
        Map<Long, Integer> equipmentQuantities = new HashMap<>();

        for (EquipmentItem equipmentItem : availableEquipmentItems) {
            Equipment equipment = equipmentItem.getEquipment();
            equipmentQuantities.merge(equipment.getId(), 1, Integer::sum);
        }

        List<EquipmentResponseDTO> equipmentsDTO = new ArrayList<>();

        equipmentQuantities.forEach((equipmentId, quantityAvailable) -> {
            Equipment equipment = equipmentRepository.findById(equipmentId).orElseThrow();
            EquipmentResponseDTO dto = EquipmentResponseDTO.builder()
                    .id(equipment.getId())
                    .name(equipment.getName())
                    .equipmentFamily(equipment.getEquipmentFamily())
                    .quantityAvailable(quantityAvailable)
                    .build();
            equipmentsDTO.add(dto);
        });

        return equipmentsDTO;
    }

    public List<EquipmentItem> findAvailableEquipmentItemsByEquipmentId(Long id, LocalDateTime startDate, LocalDateTime endDate) {
        return repository.findAvailableEquipmentItemsByEquipmentId(id, startDate, endDate);
    }
    public List<EquipmentItem> saveAll(List<EquipmentItem> equipmentItems) {
        return repository.saveAll(equipmentItems);
    }

}
