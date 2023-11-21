package com.rentalhive.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rentalhive.domain.listener.EquipmentListener;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @NotBlank(message = "Name is Invalid : blank name")
    private String name;

    @Min(value = 0, message = "Quantity must be greater than or equal to {value}")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "equipment_family_id")
    @NotNull(message = "Error : Equipment must not be null")
    private EquipmentFamily equipmentFamily;
}
