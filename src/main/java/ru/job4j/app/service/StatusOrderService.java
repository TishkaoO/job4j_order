package ru.job4j.app.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.job4j.app.dto.StatusOrderDto;
import ru.job4j.app.mapper.StatusOrderMapper;
import ru.job4j.app.repository.StatusRepository;

import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class StatusOrderService {
    private final StatusRepository statusRepository;
    private final StatusOrderMapper statusOrderMapper;

    public StatusOrderDto getStatusByNumberOrder(int number) {
        return statusRepository.findByNumberOrder(number)
                .map(order -> statusOrderMapper.toDto(order))
                .orElseThrow(() -> {
                    log.info("This status with number: " + number + " is not exists");
                    return new NoSuchElementException("Status is not exists");
                });
    }
}
