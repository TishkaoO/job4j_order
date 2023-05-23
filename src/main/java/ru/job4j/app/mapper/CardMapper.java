package ru.job4j.app.mapper;

import org.mapstruct.Mapper;
import ru.job4j.app.dto.CardDto;
import ru.job4j.app.entity.CardEntity;

@Mapper(componentModel = "spring")
public interface CardMapper {

    CardDto toDto(CardEntity entity);

    CardEntity toEntity(CardDto dto);
}
