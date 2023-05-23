package ru.job4j.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.app.dto.CustomerDto;
import ru.job4j.app.entity.CustomerEntity;
import ru.job4j.app.service.CustomerService;
import ru.job4j.app.service.OrderService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/customers")
public class CustomerController {
    private final ObjectMapper objectMapper;
    private final CustomerService customerService;
    private final OrderService orderService;

    @PostMapping("/sign-up")
    public ResponseEntity<CustomerDto> signUp(@RequestBody CustomerEntity customer) {
        var entity = ResponseEntity.status(HttpStatus.CREATED)
                .header("CustomHeader")
                .contentType(MediaType.APPLICATION_JSON)
                .body(customerService.save(customer));
        return entity;
    }


//    @GetMapping("/check-status")
//    public StatusOrderDto checkStatusOrder(@RequestParam int number) {
//        return statusOrderService.getStatusByNumberOrder(number);
//    } TODO:Доделать проверку статуса заказ
}
