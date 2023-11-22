package com.rentalhive.domain.listener;

import com.rentalhive.domain.Equipment;
import com.rentalhive.domain.EquipmentItem;
import com.rentalhive.service.impl.EquipmentItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Component
public class EquipmentListener {

    private static EquipmentItemServiceImpl equipmentItemService;
    @Autowired
    public void setEquipmentItemService(EquipmentItemServiceImpl equipmentItemService) {
        EquipmentListener.equipmentItemService = equipmentItemService;
    }


    @PostPersist
    public void equipmentItemsGenerator(Equipment equipment) {
        List<EquipmentItem> equipmentItems = createEquipmentItems(equipment.getQuantity(), equipment);
        equipmentItemService.saveAll(equipmentItems);
    }

    @PostUpdate
    public void postUpdate(Equipment equipment){
        int numberOfEquipmentItems = equipmentItemService.countEquipmentItemsByEquipmentId(equipment.getId());
        int newQuantity = equipment.getQuantity() - numberOfEquipmentItems;
        List<EquipmentItem> equipmentItems = createEquipmentItems(newQuantity, equipment);
        equipmentItemService.saveAll(equipmentItems);
    }

    private List<EquipmentItem> createEquipmentItems(int numberOfItems, Equipment equipment){
        List<EquipmentItem> equipmentItems = new ArrayList<>();
        for (int i = 1; i <= numberOfItems; i++) {
            equipmentItems.add(
                    EquipmentItem.builder()
                            .equipment(equipment)
                            .reference(UUID.randomUUID().toString())
                            .build()
            );
        }
        return equipmentItems;
    }
}
