package com.busra.couriertracking.controller;

import com.busra.couriertracking.controller.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerErrorHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleError(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorMessage(e.getMessage());
        return errorResponse;
    }

}