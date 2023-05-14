package ru.job4j.app.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
public class CardDto {

    private String nameOwner;

    private String cardNumber;

    private LocalDateTime expiryDate;

    private String cvv;
}
