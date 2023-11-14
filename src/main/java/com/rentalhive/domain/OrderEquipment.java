package com.rentalhive.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double rentPrice;
    @ManyToOne
    private Order order;
    @ManyToOne
    private EquipmentItem equipmentItem;

}
