package ru.job4j.app.mapper;

import org.mapstruct.Mapper;
import ru.job4j.app.dto.OrderDto;
import ru.job4j.app.model.Order;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto toDto(Order order);

    List<OrderDto> toDto(List<Order> orders);

    Order toEntity(OrderDto dto);

    List<Order> toEntity(List<OrderDto> dtos);
}
