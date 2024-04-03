package com.example.jparelationonetoone.Api;


public class ApiException extends RuntimeException{
    private String message;

    public ApiException(String message){
        super(message);
    }
}
