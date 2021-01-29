package com.vallegrande.sadeb.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

import javax.validation.ConstraintViolationException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Martín Alexis Samán Arata - martin.saman@vallegrande.edu.pe
 * Global exceptions for rest controllers
 */
@RestControllerAdvice
public class GlobalExceptionHandlers {
    /**
     * Return a bad request when client send invalid parameters
     * Override default map provided for Spring
     *
     * @param constraintViolationException error provided by validation class
     * @return message from custom error
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Mono<GlobalExceptionMessage> handleConstraintViolationException(
            ConstraintViolationException constraintViolationException) {
        return Mono.just(GlobalExceptionMessage.builder()
                .timestamp(ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT))
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(constraintViolationException.getMessage())
                .exception("javax.validation.ConstraintViolationException")
                .build());
    }
}
