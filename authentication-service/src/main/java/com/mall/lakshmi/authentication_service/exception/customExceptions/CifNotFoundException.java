//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_service.exception.customExceptions;

public class CifNotFoundException extends RuntimeException {
    public CifNotFoundException(String cifNumber) {
        super("CIF number " + cifNumber + " not found");
    }
}
