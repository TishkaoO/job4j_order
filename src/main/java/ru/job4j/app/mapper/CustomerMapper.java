package ru.job4j.app.mapper;

import org.mapstruct.Mapper;
import ru.job4j.app.dto.CustomerDto;
import ru.job4j.app.entity.CustomerEntity;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto toDto(CustomerEntity entity);

    CustomerEntity toEntity(CustomerDto dto);
}
