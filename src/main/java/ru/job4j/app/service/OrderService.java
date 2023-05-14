package ru.job4j.app.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.job4j.app.dto.OrderDto;
import ru.job4j.app.mapper.OrderMapper;
import ru.job4j.app.model.Order;
import ru.job4j.app.model.StatusOrder;
import ru.job4j.app.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    private int countNumberOrder = 1;

    public OrderDto createOrder(Order order) {
        Order builder = Order.builder()
                .name(order.getName())
                .numberOrder(countNumberOrder++)
                .createdDate(LocalDateTime.now())
                .statusOrder(
                        StatusOrder.builder()
                                .name("not paid")
                                .description("after payment, the order will be processed")
                                .build()
                )
                .build();
        orderRepository.save(builder);
        log.info("Order added!");
        return orderMapper.toDto(builder);
    }

    public void deleteById(Long id) {
        Order findOrder = orderRepository.findById(id)
                .orElseThrow(() -> {
                    log.info("This order with id: " + id + " is not exists");
                    return new NoSuchElementException("Order is not exists");
                });
        orderRepository.delete(findOrder);
    }

    public OrderDto getOrderById(Long id) {
        return orderRepository.findById(id)
                .map(order -> orderMapper.toDto(order))
                .orElseThrow(() -> {
                    log.info("This order with id: " + id + " is not exists");
                    return new NoSuchElementException("Order is not exists");
                });
    }

    public OrderDto update(Order order) {
        Order findOrderAndUpdate = orderRepository.findById(order.getId())
                .map(entity -> Order.builder()
                        .statusOrder(order.getStatusOrder())
                        .build())
                .orElseThrow(() -> {
                    log.info("This order with id: " + order.getId() + " is not exists!");
                    return new NoSuchElementException("Order is not exists");
                });
        return orderMapper.toDto(findOrderAndUpdate);
    }

    public Order getOrderByCardNumber(String cardNumber) {
        Order order = orderRepository.findByCardNumber(cardNumber)
                .orElseThrow(() -> {
                    log.info("This Order with card number: " + cardNumber + " is not exists!");
                    return new NoSuchElementException("Order is not exists");
                });
        return order;
    }
}
