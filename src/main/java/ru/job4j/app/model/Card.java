package ru.job4j.app.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_owner")
    private String nameOwner;

    @Column(name = "card_number")
    private String number;

    private LocalDateTime expiryDate;

    private String cvv;

    private int balance;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customers_id")
    private Customer customer;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Payment> payments;
}
