package org.equipe_9.uniufc.domain.restful;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
            MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> erros = ex.getBindingResult().getFieldErrors().stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                .toList();
        return ResponseEntity.badRequest().body(Map.of("errors", erros));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolations(ConstraintViolationException ex) {
        List<String> erros = ex.getConstraintViolations().stream()
                .map(e -> e.getPropertyPath() + ": " + e.getMessage())
                .toList();
        return ResponseEntity.badRequest().body(Map.of("errors", erros));
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<?> handleBindException(BindException ex) {
        List<String> errors = ex.getFieldErrors().stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                .toList();
        return ResponseEntity.badRequest().body(Map.of("errors", errors));
    }
}

