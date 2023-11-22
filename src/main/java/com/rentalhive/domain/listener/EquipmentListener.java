package com.rentalhive.domain.listener;

import com.rentalhive.domain.Equipment;
import com.rentalhive.domain.EquipmentItem;
import com.rentalhive.enums.EquipmentItemStatus;
import com.rentalhive.service.impl.EquipmentItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Component
public class EquipmentListener {

    private static EquipmentItemServiceImpl equipmentItemService;
    //Todo:: fix this
    @Autowired
    public void setEquipmentItemService(EquipmentItemServiceImpl equipmentItemService) {
        EquipmentListener.equipmentItemService = equipmentItemService;
    }
    @PostPersist
    public void postPersist(Equipment equipment){
        equipmentItemsGenerator(equipment);
    }
    public void equipmentItemsGenerator(Equipment equipment) {
        List<EquipmentItem> equipmentItems = new ArrayList<>();
        for (int i = 1; i <= equipment.getQuantity(); i++) {
            equipmentItems.add(
                    EquipmentItem.builder()
                            .equipment(equipment)
                            .status(EquipmentItemStatus.AVAILABLE)
                            .reference(UUID.randomUUID().toString())
                            .build()
            );
        }
        equipmentItemService.saveAll(equipmentItems);
    }
}
