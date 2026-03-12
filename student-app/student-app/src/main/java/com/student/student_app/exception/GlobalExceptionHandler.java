package com.student.student_app.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handles validation errors!
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>>
    handleValidationErrors(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
                .getAllErrors()
                .forEach(error -> {
                    String fieldName =
                            ((FieldError) error).getField();
                    String message =
                            error.getDefaultMessage();
                    errors.put(fieldName, message);
                });

        return ResponseEntity.status(400).body(errors);
    }

    // Handles not found errors!
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String>
    handleException(RuntimeException ex) {
        return ResponseEntity
                .status(404)
                .body(ex.getMessage());
    }
}
