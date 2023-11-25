package com.rentalhive.domain;

import com.rentalhive.enums.OfferStatus;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double overallCost;
    @Enumerated(EnumType.STRING)
    private OfferStatus status;
    private Boolean negotiable;
    @ManyToOne
    private Order order;
}
