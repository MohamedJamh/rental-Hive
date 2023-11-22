package com.rentalhive.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rentalhive.domain.listener.EquipmentListener;
import lombok.*;

import javax.persistence.*;
@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(EquipmentListener.class)
public class Equipment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private EquipmentFamily equipmentFamily;
}
