package ru.job4j.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.job4j.app.dto.AscDto;
import ru.job4j.app.dto.OrderDto;
import ru.job4j.app.entity.OrderEntity;
import ru.job4j.app.service.OrderService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create/customer-order/{customer_id}")
    public OrderDto createOrder(@PathVariable("customer_id") Long customerId, @RequestParam("dish_id") List<Long> dishsId) {
        return orderService.createOrder(customerId, dishsId);
    }

    @PatchMapping("/update/{order_id}")
    public OrderDto update(@PathVariable("order_id") Long orderId, @RequestParam("dish_id") Long dishId,
                           @RequestParam("number") int numberOfDish) {
        return orderService.update(orderId, dishId, numberOfDish);

        //TODO: решить проблему с методом не корректно обновляет а точнее перебивает стоимость на 0
    }

    @DeleteMapping("delete/{id}")
    public AscDto deleteOrderById(@PathVariable Long id) {
        return orderService.deleteOrderById(id);
    }
}
