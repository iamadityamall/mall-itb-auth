package com.mall.lakshmi.authentication_servcie.dto;

public class CreateMpinRequest {
    private String cifNumber;
    private String mpin;

    public CreateMpinRequest() {
    }

    public CreateMpinRequest(String cifNumber, String mpin) {
        this.cifNumber = cifNumber;
        this.mpin = mpin;
    }

    public String getCifNumber() {
        return cifNumber;
    }

    public void setCifNumber(String cifNumber) {
        this.cifNumber = cifNumber;
    }

    public String getMpin() {
        return mpin;
    }

    public void setMpin(String mpin) {
        this.mpin = mpin;
    }

    @Override
    public String toString() {
        return "CreateMpinRequest{" +
                "cifNumber='" + cifNumber + '\'' +
                ", mpin='" + mpin + '\'' +
                '}';
    }
}
