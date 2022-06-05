package com.tyler.tracex.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends BaseController {

    @ExceptionHandler({ IllegalArgumentException.class })
    public ResponseEntity<?> handleExceptionA(IllegalArgumentException e) {
        return toExceptionResult(e.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<?> handleExceptionA(Exception e) {
        return toExceptionResult(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

}
