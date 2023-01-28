package com.francisca.datawarehouse.controller;

import com.francisca.datawarehouse.exception.DealAlreadyExistException;
import com.francisca.datawarehouse.exception.DealNotFoundException;
import com.francisca.datawarehouse.exception.ExceptionResponse;
import com.francisca.datawarehouse.exception.InvalidCurrencyException;
import com.francisca.datawarehouse.response.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionController {


    private final ResponseService<ExceptionResponse> responseService;

    @ExceptionHandler(DealAlreadyExistException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFoundHandler(DealAlreadyExistException exception){
        return responseService.response(new ExceptionResponse(exception.getMessage(), LocalDateTime.now() , HttpStatus.CONFLICT), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidCurrencyException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFoundHandler(InvalidCurrencyException exception){
        return responseService.response(new ExceptionResponse(exception.getMessage(), LocalDateTime.now() , HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DealNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFoundHandler(DealNotFoundException exception){
        return responseService.response(new ExceptionResponse(exception.getMessage(), LocalDateTime.now() , HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }
}
