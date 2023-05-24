package ru.job4j.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.app.entity.OrderEntity;
import ru.job4j.app.entity.StatusOrderEntity;
import ru.job4j.app.exceptions.BadRequestException;
import ru.job4j.app.repository.StatusOrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusOrderService {
    private final StatusOrderRepository statusOrderRepository;

    public void save(StatusOrderEntity entity) {
        statusOrderRepository.save(entity);
    }

    public StatusOrderEntity getStatusByName(String name) {
        return statusOrderRepository.findByName(name)
                .orElseThrow(() -> new BadRequestException("status not found"));
    }

    public StatusOrderEntity getStatusOrderEntityByIdOrElseThrow(Long id) {
        return statusOrderRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("status not found"));
    }

    public void removeOrderFromStatus(Long orderId) {
        StatusOrderEntity statusOrder = getStatusByName("waiting for payment");
        List<OrderEntity> orders = statusOrder.getOrders();
        orders.removeIf(order -> order.getId().equals(orderId));
        statusOrderRepository.save(statusOrder);
    }
}
