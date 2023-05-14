package ru.job4j.app.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "customer",
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Order> orders;

    @OneToMany(mappedBy = "customer",
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Payment> payments;

    @OneToMany(mappedBy = "customer",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Card> cards;
}
