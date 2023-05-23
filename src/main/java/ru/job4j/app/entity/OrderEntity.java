package ru.job4j.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "number_order")
    private int numberOrder;

    @Column(name = "created_date")
    private Instant createdAt;

    @OneToMany
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private List<DishEntity> dishs = new ArrayList<>();
}
