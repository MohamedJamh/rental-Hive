package com.rentalhive.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime rentStartDate;
    private LocalDateTime rentEndDate;
    @OneToOne
    private Location constructLocation;
    @OneToMany(mappedBy = "order")
    private List<OrderEquipment> orderEquipments;
}
