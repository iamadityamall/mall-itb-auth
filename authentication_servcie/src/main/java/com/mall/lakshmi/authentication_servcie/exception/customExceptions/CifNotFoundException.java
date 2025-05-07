

package com.mall.lakshmi.authentication_servcie.exception.customExceptions;

public class CifNotFoundException extends RuntimeException {
    public CifNotFoundException(String cifNumber) {
        super("CIF number " + cifNumber + " not found");
    }
}
