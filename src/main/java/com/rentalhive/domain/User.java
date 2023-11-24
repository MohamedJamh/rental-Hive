package com.rentalhive.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime verifiedAt;
    @ManyToMany
    private List<Role> roles;
    @OneToOne
    private Organization organization;
    @OneToMany
    private List<Order> orders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getId(), user.getId()) && Objects.equals(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail());
    }
}
