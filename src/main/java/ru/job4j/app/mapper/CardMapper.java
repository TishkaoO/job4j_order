package ru.job4j.app.mapper;

import org.mapstruct.Mapper;
import ru.job4j.app.dto.CardDto;
import ru.job4j.app.model.Card;

@Mapper(componentModel = "spring")
public interface CardMapper {

    CardDto toDto(Card card);

    Card toEntity(CardDto dto);
}
