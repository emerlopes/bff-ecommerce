package br.com.emerlopes.bffecommerce.application.exceptions;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FeignException.Conflict.class)
    public ResponseEntity<Map<String, String>> handleFeignConflictException(FeignException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("errorCode", "USER_ALREADY_EXISTS");
        errorResponse.put("message", "Is not possible to register a user with the same username.");
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

}