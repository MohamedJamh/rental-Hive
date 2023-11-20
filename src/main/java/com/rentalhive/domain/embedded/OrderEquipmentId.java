package com.rentalhive.domain.embedded;

import com.rentalhive.domain.EquipmentItem;
import com.rentalhive.domain.Order;
import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderEquipmentId implements Serializable {

    @ManyToOne
    private Order order;

    @ManyToOne
    private EquipmentItem equipmentItem;

}