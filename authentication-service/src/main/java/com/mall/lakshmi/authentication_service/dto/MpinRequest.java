//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_service.dto;

import jakarta.validation.constraints.NotBlank;

public class MpinRequest {
    private @NotBlank(
            message = "CIF number cannot be blank"
    ) String cifNumber;
    private @NotBlank(
            message = "MPIN cannot be blank"
    ) String mpin;

    public MpinRequest() {
    }

    public MpinRequest(String cifNumber, String mpin) {
        this.cifNumber = cifNumber;
        this.mpin = mpin;
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

    public String toString() {
        return "MpinRequest{cifNumber='" + this.cifNumber + "', mpin='" + this.mpin + "'}";
    }
}
