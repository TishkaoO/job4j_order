package ru.job4j.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PaymentException extends RuntimeException {

    public PaymentException(String message) {
        super(message);
    }
}
