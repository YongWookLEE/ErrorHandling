package com.example.testest.exception;

/**
 * WrongExcutionException.java
 * Class 설명을 작성하세요.
 *
 * @author danusys
 * @since 2023.03.09
 */
public class WrongExecutionException extends RuntimeException {
    private static final String CODE = "12";
    public WrongExecutionException(String message){
        super(message);
    }
    public String getCODE() {return CODE;}
}
