package com.rentalhive.domain;

import com.rentalhive.enums.EquipmentItemStatus;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String reference;
    @Enumerated(EnumType.STRING)
    private EquipmentItemStatus status = EquipmentItemStatus.AVAILABLE;
    @OneToMany(mappedBy = "equipmentItem")
    private List<OrderEquipment> orderEquipments;
}
