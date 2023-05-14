package ru.job4j.app.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
public class OrderDto {

    private String name;

    private int numberOrder;

    private LocalDateTime createdDate = LocalDateTime.now();

    private StatusOrderDto statusOrder;

    private PaymentDto payment;
}
