package ru.job4j.app.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DishDto {
    private String name;
    private double price;
}
