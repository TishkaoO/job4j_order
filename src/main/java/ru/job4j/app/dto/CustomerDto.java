package ru.job4j.app.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerDto {

    private String username;

    private String password;

    private String phoneNumber;
}
