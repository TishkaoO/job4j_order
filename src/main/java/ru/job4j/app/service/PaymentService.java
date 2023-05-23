package ru.job4j.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.app.dto.AscDto;
import ru.job4j.app.entity.OrderEntity;
import ru.job4j.app.mapper.OrderMapper;
import ru.job4j.app.repository.CustomerRepository;
import ru.job4j.app.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final OrderService orderService;
    private final CardService cardService;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final CustomerRepository customerRepository;

    public AscDto payToTheOrder(Long orderId) {
        //открыл заказ
        OrderEntity order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Card is not exists"));
        //узнать какому юзеру принадлежит этот номер заказ
        // и как раз с этого юзера списать лаве
        //нужно понять сумму заказа и после просто списать эту сумму с карты
        // если сумма меньше 500 руб то предложить доплатить
        // если отказывается то списываем сколько он сказал и возвращаем сообщение чтоб заплатил курьеру
        // если больше то списать с карты эту сумму
//        OrderDto dto = orderMapper.toDto(order);
//        double sumPay = dto.getToPay();
//        if (sumPay < 500) {
//            //message
//        } else {
//            customerRepository.findById();
//                    //узнать какому юзеру принадлежит этот номер заказ
//            // и как раз с этого юзера списать лаве
//        }
//
//    }
        return null;
    }
}
