package com.thoughtworks.capacity.gtb.mvc.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UsernamePasswordNotMatchingException.class)
    public ResponseEntity<ErrorResult> handle(UsernamePasswordNotMatchingException error) {
        ErrorResult errorResult = new ErrorResult(HttpStatus.BAD_REQUEST, error.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ErrorResult> handle(UserAlreadyExistException error) {
        ErrorResult errorResult = new ErrorResult(HttpStatus.BAD_REQUEST, error.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> handle(MethodArgumentNotValidException error) {
        String message = error.getBindingResult().getFieldError().getDefaultMessage();
        ErrorResult errorResult = new ErrorResult(HttpStatus.BAD_REQUEST, message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResult> handle(ConstraintViolationException error) {
        Set<ConstraintViolation<?>> violations = error.getConstraintViolations();

        String message = "";
        for (ConstraintViolation<?> constraint : error.getConstraintViolations()) {
            message = constraint.getMessage();
            break;
        }
        ErrorResult errorResult = new ErrorResult(HttpStatus.BAD_REQUEST, message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }
}
