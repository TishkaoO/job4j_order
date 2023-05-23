package ru.job4j.app.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.job4j.app.dto.CardDto;
import ru.job4j.app.entity.CardEntity;
import ru.job4j.app.entity.CustomerEntity;
import ru.job4j.app.mapper.CardMapper;
import ru.job4j.app.repository.CardRepository;
import ru.job4j.app.repository.CustomerRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final CustomerRepository customerRepository;
    private final CardMapper cardMapper;

    public CardDto createCard(Long customerId, String nameOwner, String cardNumber, LocalDateTime expiryDate, String cvv) {
        CardEntity cardEntity = CardEntity.builder()
                .nameOwner(nameOwner)
                .cardNumber(cardNumber)
                .expiryDate(expiryDate)
                .balance(50)
                .cvv(cvv)
                .build();
        cardRepository.save(cardEntity);
        linkCardToCustomer(customerId, cardEntity.getId());
        return cardMapper.toDto(cardEntity);
    }

    private void linkCardToCustomer(Long customerId, Long cardId) {
        CustomerEntity customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("customer not found"));
        CardEntity card = cardRepository.findById(cardId).orElseThrow(() -> new IllegalArgumentException("card not found"));
        customer.getCards().add(card);
        cardRepository.save(card);
    }
}
