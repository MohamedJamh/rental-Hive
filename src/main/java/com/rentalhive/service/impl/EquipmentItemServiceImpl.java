package com.rentalhive.service.impl;

import com.rentalhive.domain.EquipmentItem;
import com.rentalhive.dto.response.EquipmentResponseDTO;
import com.rentalhive.enums.EquipmentItemStatus;
import com.rentalhive.repository.EquipmentItemRepository;
import com.rentalhive.service.EquipmentItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class EquipmentItemServiceImpl implements EquipmentItemService {

    private final EquipmentItemRepository repository;

    @Override
    public List<EquipmentResponseDTO> findAvailableEquipments(LocalDateTime startDate, LocalDateTime endDate) {
        return  repository.findAvailableEquipmentResponseDTO(
                EquipmentItemStatus.AVAILABLE,startDate, endDate);
    }

    @Override
    public List<EquipmentItem> findAvailableEquipmentItemsByEquipmentId(Long id, LocalDateTime startDate, LocalDateTime endDate) {
        return repository.findAvailableEquipmentItemsByEquipmentId(
                EquipmentItemStatus.AVAILABLE, id, startDate, endDate);
    }

    @Override
    public List<EquipmentItem> saveAll(List<EquipmentItem> equipmentItems) {
        return repository.saveAll(equipmentItems);
    }

    @Override
    public int countEquipmentItemsByEquipmentId(Long id) {
        return repository.countByEquipmentId(id);
    }
}
