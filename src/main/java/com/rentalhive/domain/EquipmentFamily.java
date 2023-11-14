package com.rentalhive.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentFamily {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    private List<Equipment> equipment;
}
