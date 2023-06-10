package com.entitylogic.github.extractor.infrastructure;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class GlobalErrorHandler {

    @ExceptionHandler
    ResponseEntity<Object> handleException(Exception exception) {
        return new ResponseEntity<>("Unexpected exception occurred: " + exception, HttpStatus.BAD_REQUEST);
    }
}
