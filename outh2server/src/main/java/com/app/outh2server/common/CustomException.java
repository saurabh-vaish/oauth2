package com.app.outh2server.common;

import org.springframework.http.HttpStatus;

/**
 * Custom Exception
 */
public class CustomException extends RuntimeException{

    private  HttpStatus statusCode;
    private Boolean error = Boolean.TRUE;
    private  int errorCode;

    public CustomException(){}

    /**
     * Constructor for CustomException
     */
    public CustomException(String exceptionMessage, HttpStatus statusCode) {
        super(exceptionMessage);
        this.statusCode = statusCode;
        this.errorCode = statusCode.value();
    }

}
