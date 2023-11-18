package com.rentalhive.domain.embedded;

import com.rentalhive.domain.EquipmentItem;
import com.rentalhive.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEquipmentId implements Serializable {

    @ManyToOne
    private Order order;

    @ManyToOne
    private EquipmentItem equipmentItem;

}