package ru.job4j.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.app.dto.AscDto;
import ru.job4j.app.entity.CardEntity;
import ru.job4j.app.entity.DishEntity;
import ru.job4j.app.entity.OrderEntity;
import ru.job4j.app.entity.StatusOrderEntity;
import ru.job4j.app.exceptions.PaymentException;
import ru.job4j.app.mapper.OrderMapper;
import ru.job4j.app.repository.CustomerRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final OrderService orderService;
    private final CardService cardService;
    private final OrderMapper orderMapper;
    private final CustomerRepository customerRepository;
    private final StatusOrderService statusOrderService;

    public AscDto payToTheOrder(Long orderId, Long cardId) {
        OrderEntity order = orderService.getOrderEntityByIdOrElseThrow(orderId);
        CardEntity card = cardService.getCardByIdOrElseThrow(cardId);
        StatusOrderEntity status = statusOrderService.getStatusByName("order has been paid");
        double debit = 0;
        LocalDateTime currentDateTime = LocalDateTime.now();
        List<DishEntity> dishEntities = order.getDishs().stream()
                .collect(Collectors.toList());
        double totalAmountOfTheOrder = dishEntities.stream()
                .mapToDouble(DishEntity::getPrice)
                .sum();
        if(card.getExpiryDate().isBefore(currentDateTime)) {
            throw new PaymentException("The card has expired.");
        }
        if (totalAmountOfTheOrder <= card.getBalance()) {
            debit = card.getBalance() - totalAmountOfTheOrder;
            card.setBalance(debit);
            cardService.saveCard(card);
            statusOrderService.removeOrderFromStatus(orderId);
            orderService.linkOrderToStatusOrder(orderId, status.getId());
            return AscDto.builder()
                    .answer("payment was successful!")
                    .build();
        }
        throw new PaymentException("insufficient funds");
    }
}
