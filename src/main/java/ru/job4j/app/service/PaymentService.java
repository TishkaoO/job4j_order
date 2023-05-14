package ru.job4j.app.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.job4j.app.model.Card;
import ru.job4j.app.model.Order;
import ru.job4j.app.model.StatusOrder;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentService {
    private final OrderService orderService;
    private final CardService cardService;

    public boolean payForTheOrder(Card cardPay) {
        Card card = cardService.getCardByCardNumber(cardPay.getNumber());
        Order order = orderService.getOrderByCardNumber(cardPay.getNumber());
        if (!card.getCustomer().getPhoneNumber().equals(order.getCustomer().getPhoneNumber())) {
            return false;
        }
        if (card.getBalance() < order.getPayment().getPaymentAmount()) {
            return false;
        }
        card.setBalance(card.getBalance() - order.getPayment().getPaymentAmount());
        cardService.update(card);
        order.setStatusOrder(StatusOrder.builder()
                .name("order has been paid")
                .description("thanks for the payment!!! "
                        + "courier will arrive in 30 minutes")
                .build());
        orderService.update(order);
        log.info("order payment was successful");
        return true;
    }
}
