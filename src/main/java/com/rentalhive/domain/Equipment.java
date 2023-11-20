package com.rentalhive.domain;

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
public class Equipment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Name is Invalid : blank name")
    private String name;

    @Min(value = 0, message = "Quantity must be greater than or equal to {value}")
    private Integer quantity;

    @ManyToOne
    private EquipmentFamily equipmentFamily;
}
