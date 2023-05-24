package ru.job4j.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.app.dto.StatusOrderDto;
import ru.job4j.app.service.StatusOrderService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/status")
public class StatusOrderController {
    private final StatusOrderService statusOrderService;

    @GetMapping("/check-status")
    public StatusOrderDto checkStatusOrder(@RequestParam int number) {
        return statusOrderService.getStatusByNumberOrder(number);
    }
}
