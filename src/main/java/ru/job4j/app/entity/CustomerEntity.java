package ru.job4j.app.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String username;

    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private List<OrderEntity> orders = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Set<CardEntity> cards = new HashSet<>();
}
