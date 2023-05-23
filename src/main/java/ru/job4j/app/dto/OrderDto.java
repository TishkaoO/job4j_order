package ru.job4j.app.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class OrderDto {

    private int numberOrder;

    private List<DishDto> dishs;

    private StatusOrderDto statusOrder;

    private double toPay;

    private Instant createdAt = Instant.now();
}
