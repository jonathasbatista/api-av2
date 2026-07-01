package com.api.av2.infrastructure;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException ex) {
        Map<String, String> erro = new HashMap<>();
        erro.put("mensagem", ex.getMessage());
        erro.put("status", "400");

        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }
}