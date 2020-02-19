package com.app.outh2server.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * Thrymr AutoGenerated ExceptionHandler
 */
@RestControllerAdvice
public class CustomExceptionHandler {

    /**
     * Handler Method for CustomException
     */
    @ExceptionHandler(CustomException.class)
    public AppResponse handleCustomException(){
       return new AppResponse(HttpStatus.BAD_REQUEST);
    }
}
