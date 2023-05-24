package ru.job4j.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.job4j.app.dto.CardDto;
import ru.job4j.app.service.CardService;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cards")
public class CardController {
    private final CardService cardService;

    @PostMapping("/create/card-customer/{customer_id}")
    public CardDto createCard(@PathVariable("customer_id") Long customerId,
                              @RequestParam("name_owner") String nameOwner,
                              @RequestParam("card_number") String cardNumber,
                              @RequestParam("expiry_date") LocalDateTime expiryDate,
                              @RequestParam("cvv") String cvv) {
        return cardService.createCard(customerId, nameOwner, cardNumber,
                expiryDate, cvv);
    }
}
