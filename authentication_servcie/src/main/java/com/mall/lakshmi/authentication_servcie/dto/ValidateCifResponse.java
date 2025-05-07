//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_servcie.dto;

public class ValidateCifResponse {
    private String cifNumber;
    private boolean isRegistered;

    public ValidateCifResponse(String cifNumber, boolean isRegistered) {
        this.cifNumber = cifNumber;
        this.isRegistered = isRegistered;
    }

    public String getCifNumber() {
        return this.cifNumber;
    }

    public void setCifNumber(String cifNumber) {
        this.cifNumber = cifNumber;
    }

    public boolean isRegistered() {
        return this.isRegistered;
    }

    public void setRegistered(boolean registered) {
        this.isRegistered = registered;
    }

    public String toString() {
        return "ValidateCifResponse{cifNumber='" + this.cifNumber + "', isRegistered=" + this.isRegistered + "}";
    }
}
