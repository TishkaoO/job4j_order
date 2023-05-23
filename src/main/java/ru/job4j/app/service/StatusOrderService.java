package ru.job4j.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.app.entity.StatusOrderEntity;
import ru.job4j.app.repository.StatusOrderRepository;

@Service
@RequiredArgsConstructor
public class StatusOrderService {
    private final StatusOrderRepository orderRepository;

    public void save(StatusOrderEntity entity) {
        orderRepository.save(entity);
    }

    public StatusOrderEntity getStatusByName(String name) {
        return orderRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public StatusOrderEntity getStatusOrderEntityByIdOrElseThrow(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
    }
    //TODO:добить присвоение статуса заказу
}
