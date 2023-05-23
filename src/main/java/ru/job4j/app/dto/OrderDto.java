package ru.job4j.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class OrderDto {

    private int numberOrder;

    private List<DishDto> dishDtos;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Your_Timezone")
    private Instant createdDate = Instant.now();

    private StatusOrderDto statusOrder;


    private double toPay;
}
