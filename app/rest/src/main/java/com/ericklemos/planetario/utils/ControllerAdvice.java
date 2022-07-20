package com.ericklemos.planetario.utils;

import com.ericklemos.planetario.core.utils.validator.ValidationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ValidationException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {

        var descricao = Arrays.stream(ex.getSuppressed())
                .map(Throwable::getMessage)
                .collect(Collectors.joining(", "));

        var mensagem = Mensagem.builder()
                .titulo("erro na validação dos campos enviados")
                .descricao(descricao)
                .build();

        return handleExceptionInternal(ex, mensagem,
                new HttpHeaders(), HttpStatus.CONFLICT, request);

    }

}
