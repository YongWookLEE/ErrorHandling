package com.example.testest.exception;

/**
 * InvalidRequestParameterException.java
 * Class 설명을 작성하세요.
 *
 * @author danusys
 * @since 2023.03.09
 */
public class InvalidRequestParameterException extends RuntimeException{
    private static final String CODE = "11";
    public InvalidRequestParameterException(String message){
        super(message);
    }
    public String getCODE() {return CODE;}
}

