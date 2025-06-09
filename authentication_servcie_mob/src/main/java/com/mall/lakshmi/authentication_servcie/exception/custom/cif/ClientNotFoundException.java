package com.mall.lakshmi.authentication_servcie.exception.custom.cif;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(String message){
        super(message);
    }
}
