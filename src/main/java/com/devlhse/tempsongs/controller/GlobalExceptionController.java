package com.devlhse.tempsongs.controller;

import com.devlhse.tempsongs.dto.ErrorMessage;
import com.devlhse.tempsongs.exception.CityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleNotFoundException(Exception e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
    }

}
