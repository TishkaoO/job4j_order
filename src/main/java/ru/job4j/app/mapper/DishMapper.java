package ru.job4j.app.mapper;

import org.mapstruct.Mapper;
import ru.job4j.app.dto.DishDto;
import ru.job4j.app.entity.DishEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DishMapper {

    DishDto toDto(DishEntity entity);

    DishEntity toEntity(DishDto dto);

    List<DishDto> toDto(List<DishEntity> burger);

    List<DishEntity> toEntity(List<DishDto> burger);
}
