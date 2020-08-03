package com.adorsys.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

  Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

  @ExceptionHandler(CustomException.class)
  public ResponseEntity<Object> handleException(CustomException e) {
    logger.error("NOT FOUND", e);
    return new ResponseEntity<>("The employee id is not available.", HttpStatus.NOT_FOUND);
  }
}
