package ru.job4j.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.job4j.app.dto.AscDto;
import ru.job4j.app.service.PaymentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/to-pay/{orderId}")
    public AscDto payToTheOrder(@PathVariable Long orderId, @RequestParam Long cardId) {
        return paymentService.payToTheOrder(orderId, cardId);
    }
}
