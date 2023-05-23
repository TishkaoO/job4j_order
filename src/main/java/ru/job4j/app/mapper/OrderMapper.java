package ru.job4j.app.mapper;

import org.mapstruct.Mapper;
import ru.job4j.app.dto.OrderDto;
import ru.job4j.app.entity.OrderEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto toDto(OrderEntity entity);

    List<OrderDto> toDto(List<OrderEntity> entities);

    OrderEntity toEntity(OrderDto dto);

    List<OrderEntity> toEntity(List<OrderDto> dtos);
}
