package ru.job4j.app.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StatusOrderDto {

    private String name;

    private String description;
}
