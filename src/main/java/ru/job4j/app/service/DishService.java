package ru.job4j.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.app.entity.DishEntity;
import ru.job4j.app.repository.DishRepository;

@Service
@RequiredArgsConstructor
public class DishService {
    private final DishRepository dishRepository;

    public DishEntity getDishEntityByIdOrElseThrow(Long dishId) {
        DishEntity entity = dishRepository.findById(dishId)
                .orElseThrow(() -> new IllegalArgumentException("Dish is not exists"));
        return entity;
    }
}
