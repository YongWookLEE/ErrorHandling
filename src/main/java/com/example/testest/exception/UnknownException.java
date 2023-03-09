package com.example.testest.exception;

/**
 * UnknownException.java
 * Class 설명을 작성하세요.
 *
 * @author danusys
 * @since 2023.03.09
 */
public class UnknownException extends RuntimeException {
    private static final String CODE = "99";
    public UnknownException(String message){super(message);}
    public String getCODE() {return CODE;}
}
