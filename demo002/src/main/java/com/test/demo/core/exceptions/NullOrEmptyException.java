package com.test.demo.core.exceptions;

public class NullOrEmptyException extends Exception {
    private String message = "";
    public NullOrEmptyException(){}
    public NullOrEmptyException(String msg){
        this.message = msg;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}