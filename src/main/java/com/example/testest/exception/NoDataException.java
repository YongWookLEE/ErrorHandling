package com.example.testest.exception;

/**
 * NoDataException.java
 * Class 설명을 작성하세요.
 *
 * @author danusys
 * @since 2023.03.09
 */
public class NoDataException extends RuntimeException{
    private static final String CODE = "01";
    public NoDataException(String message){super(message);}
    public String getCODE() {return CODE;}
}
