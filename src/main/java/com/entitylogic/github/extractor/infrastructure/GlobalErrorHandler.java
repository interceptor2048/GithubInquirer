package com.entitylogic.github.extractor.infrastructure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
class GlobalErrorHandler {

    @ExceptionHandler
    ResponseEntity<Object> handleException(Exception exception) {
        log.error("Unexpected exception occurred: {}", exception.toString());
        return new ResponseEntity<>("Unexpected exception occurred: " + exception, HttpStatus.BAD_REQUEST);
    }
}
