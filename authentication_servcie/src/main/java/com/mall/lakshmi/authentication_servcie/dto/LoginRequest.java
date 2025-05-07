//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_servcie.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
    private @NotBlank(
            message = "CIF number cannot be blank"
    ) String cifNumber;
    private @NotBlank(
            message = "MPIN cannot be blank"
    ) String mpin;
    private @NotBlank(
            message = "IMEI cannot be blank"
    ) String imei;

    public LoginRequest() {
    }

    public LoginRequest(String cifNumber, String mpin, String imei) {
        this.cifNumber = cifNumber;
        this.mpin = mpin;
        this.imei = imei;
    }

    public String getCifNumber() {
        return this.cifNumber;
    }

    public void setCifNumber(String cifNumber) {
        this.cifNumber = cifNumber;
    }

    public String getMpin() {
        return this.mpin;
    }

    public void setMpin(String mpin) {
        this.mpin = mpin;
    }

    public String getImei() {
        return this.imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String toString() {
        return "LoginRequest{cifNumber='" + this.cifNumber + "', mpin='" + this.mpin + "', imei='" + this.imei + "'}";
    }
}
