package com.mall.lakshmi.authentication_servcie.exception.custom.cif;

public class LoginAttemptLimitExceededException extends RuntimeException {
    public LoginAttemptLimitExceededException(String message) {
        super(message);
    }
}
