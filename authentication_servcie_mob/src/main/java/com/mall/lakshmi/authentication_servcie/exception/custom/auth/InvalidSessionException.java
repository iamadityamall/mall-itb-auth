package com.mall.lakshmi.authentication_servcie.exception.custom.auth;

public class InvalidSessionException extends RuntimeException{
    public InvalidSessionException(String message) {
        super(message);
    }
}
