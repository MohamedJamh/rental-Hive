package com.rentalhive.service.impl;

import com.rentalhive.domain.EquipmentItem;
import com.rentalhive.dto.response.EquipmentResponseDTO;
import com.rentalhive.enums.EquipmentItemStatus;
import com.rentalhive.repository.EquipmentItemRepository;
import com.rentalhive.repository.EquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class EquipmentItemServiceImpl {

    private final EquipmentItemRepository repository;
    private final EquipmentRepository equipmentRepository;

    public List<EquipmentItem> findAvailableEquipmentItems(LocalDateTime startDate, LocalDateTime endDate) {
        return repository.findByStatusAndAvailability(EquipmentItemStatus.AVAILABLE, startDate, endDate);
    }

    public List<EquipmentResponseDTO> findAvailableEquipments(LocalDateTime startDate, LocalDateTime endDate) {
        return  repository.findAvailableEquipmentResponseDTO(
                EquipmentItemStatus.AVAILABLE,startDate, endDate);
    }

    public List<EquipmentItem> findAvailableEquipmentItemsByEquipmentId(Long id, LocalDateTime startDate, LocalDateTime endDate) {
        return repository.findAvailableEquipmentItemsByEquipmentId(
                EquipmentItemStatus.AVAILABLE, id, startDate, endDate);
    }

    public List<EquipmentItem> saveAll(List<EquipmentItem> equipmentItems) {
        return repository.saveAll(equipmentItems);
    }

}
