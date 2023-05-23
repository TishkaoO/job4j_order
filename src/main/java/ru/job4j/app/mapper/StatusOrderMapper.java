package ru.job4j.app.mapper;

import org.mapstruct.Mapper;
import ru.job4j.app.dto.StatusOrderDto;
import ru.job4j.app.entity.StatusOrderEntity;

@Mapper(componentModel = "spring")
public interface StatusOrderMapper {

    StatusOrderDto toDto(StatusOrderEntity entity);

    StatusOrderEntity toEntity(StatusOrderDto dto);
}
