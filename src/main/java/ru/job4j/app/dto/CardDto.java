package ru.job4j.app.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class CardDto {

    private String nameOwner;

    private String cardNumber;

    private LocalDateTime expiryDate;

    private String cvv;

    private double balance;
}
