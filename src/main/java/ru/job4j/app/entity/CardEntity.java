package ru.job4j.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "card")
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_owner")
    private String nameOwner;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "expiry_date")
    private LocalDateTime expiryDate;

    private String cvv;

    private double balance;
}
