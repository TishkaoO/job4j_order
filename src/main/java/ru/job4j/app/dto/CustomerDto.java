package ru.job4j.app.dto;

import lombok.*;

import java.util.List;
import java.util.Set;

@Data
public class CustomerDto {

    private String name;

    private String email;

    private String phoneNumber;

    private List<OrderDto> orders;

    private Set<CardDto> cards;
}
