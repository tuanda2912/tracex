package com.tyler.tracex.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Objects;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerExceptionHandler extends BaseController {

    @ExceptionHandler({ MethodArgumentNotValidException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleException(MethodArgumentNotValidException e) {
        if(CollectionUtils.isEmpty(e.getFieldErrors())) {
            return toExceptionResult(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        }
        String message = e.getFieldErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(", "));
        return toExceptionResult(message, HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler({ IllegalArgumentException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleException(IllegalArgumentException e) {
        return toExceptionResult(e.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler({ Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<?> handleException(Exception e) {
        return toExceptionResult(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

}
