package com.rentalhive.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rentalhive.domain.embedded.OrderEquipmentId;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderEquipment {

    @EmbeddedId
    private OrderEquipmentId orderEquipmentId;
    private Double rentPrice;

    @ManyToOne
    @MapsId("order")
    @JsonBackReference
    private Order order;

    @ManyToOne
    @MapsId("equipmentItem")
    @JsonBackReference
    private EquipmentItem equipmentItem;

}
