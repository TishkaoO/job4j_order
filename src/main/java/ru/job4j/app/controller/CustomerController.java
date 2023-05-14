package ru.job4j.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.app.dto.OrderDto;
import ru.job4j.app.dto.StatusOrderDto;
import ru.job4j.app.model.Card;
import ru.job4j.app.model.Order;
import ru.job4j.app.service.OrderService;
import ru.job4j.app.service.PaymentService;
import ru.job4j.app.service.StatusOrderService;

@RestController
@RequestMapping("/api/v1/customer ")
@RequiredArgsConstructor
public class CustomerController {
    private final OrderService orderService;
    private final PaymentService paymentService;

    private final StatusOrderService statusOrderService;

    @PostMapping("/create-order")
    public ResponseEntity<OrderDto> createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/pay")
    public ResponseEntity<Boolean> payForTheOrder(@RequestBody Card card) {
        paymentService.payForTheOrder(card);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/check-status")
    public StatusOrderDto checkStatusOrder(@RequestParam int number) {
        return statusOrderService.getStatusByNumberOrder(number);
    }
}
