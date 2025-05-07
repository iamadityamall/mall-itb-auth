//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_service.dto;

public class MpinResponse {
    private String cifNumber;
    private String message;

    public MpinResponse() {
    }

    public MpinResponse(String cifNumber, String message) {
        this.cifNumber = cifNumber;
        this.message = message;
    }

    public String getCifNumber() {
        return this.cifNumber;
    }

    public void setCifNumber(String cifNumber) {
        this.cifNumber = cifNumber;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return "MpinResponse{cifNumber='" + this.cifNumber + "', message='" + this.message + "'}";
    }
}
