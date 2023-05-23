package ru.job4j.app.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.job4j.app.dto.AscDto;
import ru.job4j.app.dto.OrderDto;
import ru.job4j.app.dto.StatusOrderDto;
import ru.job4j.app.entity.CustomerEntity;
import ru.job4j.app.entity.DishEntity;
import ru.job4j.app.entity.OrderEntity;
import ru.job4j.app.mapper.OrderMapper;
import ru.job4j.app.repository.CustomerRepository;
import ru.job4j.app.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final CustomerRepository customerRepository;
    private final DishService dishService;

    private int countNumberOrder = 1;

    public OrderDto createOrder(Long customerId, List<Long> dishId) {
        List<DishEntity> dishEntities = dishId.stream()
                .map(id -> dishService.getDishEntityByIdOrElseThrow(id))
                .collect(Collectors.toList());
        double totalAmount = dishEntities.stream()
                .mapToDouble(DishEntity::getPrice)
                .sum();
        OrderEntity builder = OrderEntity.builder()
                .numberOrder(countNumberOrder++)
                .dishs(dishEntities)
                .build();
        orderRepository.saveAndFlush(builder);
        log.info("Order added!");
        OrderDto orderDto = orderMapper.toDto(builder);
        orderDto.setStatusOrder(StatusOrderDto.builder()
                .name("waiting for payment")
                .description("after payment, the order will be given to the kitchen")
                .build());
        orderDto.setToPay(totalAmount);
        linkOrderToCustomer(customerId, builder.getId());
        return orderDto;
    }

    public AscDto deleteOrderById(Long id) {
        OrderEntity order = getOrderEntityByIdOrElseThrow(id);
        orderRepository.delete(order);
        return AscDto.builder()
                .answer("Order deleted!")
                .build();
    }

    public OrderDto update(Long orderId, Long dishId, int numberOfDish) {
        OrderEntity order = getOrderEntityByIdOrElseThrow(orderId);
        DishEntity dish = dishService.getDishEntityByIdOrElseThrow(dishId);
        List<DishEntity> selectedBurgers = order.getDishs().stream()
                .filter(nextDish -> nextDish.getId().equals(dish.getId()))
                .collect(Collectors.toList());
        if (numberOfDish < 0) {
            throw new IllegalArgumentException("Cannot pass a negative number of burgers");
        }
        if (selectedBurgers.size() == numberOfDish) {
            throw new IllegalArgumentException("Already have the specified number of burgers");
        }
        if (selectedBurgers.size() < numberOfDish) {
            int additionalDish = numberOfDish - selectedBurgers.size();
            for (int i = 0; i < additionalDish; i++) {
                order.getDishs().add(dish);
            }
        } else {
            int remainingBurgers = selectedBurgers.size() - numberOfDish;
            order.getDishs().removeIf(selectedBurgers::contains);
        }
        double totalAmount = order.getDishs().stream()
                .mapToDouble(DishEntity::getPrice)
                .sum();
        OrderDto dto = orderMapper.toDto(order);
        dto.setToPay(totalAmount);
        OrderEntity updatedOrder = orderRepository.save(order);
        return orderMapper.toDto(updatedOrder);
    }

    public OrderEntity getOrderEntityByIdOrElseThrow(Long orderId) {
        OrderEntity order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
        return order;
    }

    public void linkOrderToCustomer(Long customerId, Long orderId) {
        CustomerEntity customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("customer not found"));
        OrderEntity order = getOrderEntityByIdOrElseThrow(orderId);
        customer.getOrders().add(order);
    }
}
