package ru.job4j.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import ru.job4j.app.dto.StatusOrderDto;
import ru.job4j.app.entity.OrderEntity;
import ru.job4j.app.entity.StatusOrderEntity;
import ru.job4j.app.exceptions.BadRequestException;
import ru.job4j.app.mapper.StatusOrderMapper;
import ru.job4j.app.repository.StatusOrderRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StatusOrderService {
    private final StatusOrderRepository statusOrderRepository;
    private final StatusOrderMapper statusOrderMapper;

    public void save(StatusOrderEntity entity) {
        statusOrderRepository.save(entity);
    }

    public StatusOrderEntity getStatusByName(String name) {
        return statusOrderRepository.findByName(name)
                .orElseThrow(() -> new BadRequestException("status not found"));
    }

    public StatusOrderDto getStatusByNumberOrder(int numberOrder) {
        return statusOrderRepository.findByOrderNumber(numberOrder)
                .map(status -> statusOrderMapper.toDto(status))
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
