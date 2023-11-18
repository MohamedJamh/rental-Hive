package com.rentalhive.domain;

import com.rentalhive.domain.embedded.OrderEquipmentId;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderEquipment {

    @EmbeddedId
    private OrderEquipmentId orderEquipmentId;
    private Double rentPrice;

    @ManyToOne
    @MapsId("order")
    private Order order;

    @ManyToOne
    @MapsId("equipmentItem")
    private EquipmentItem equipmentItem;

}
