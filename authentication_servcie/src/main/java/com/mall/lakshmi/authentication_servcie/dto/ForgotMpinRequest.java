package com.mall.lakshmi.authentication_servcie.dto;

public class ForgotMpinRequest {
    private String cifNumber;
    private String newMpin;

    public ForgotMpinRequest() {
    }

    public ForgotMpinRequest(String cifNumber, String newMpin) {
        this.cifNumber = cifNumber;
        this.newMpin = newMpin;
    }

    public String getCifNumber() {
        return cifNumber;
    }

    public void setCifNumber(String cifNumber) {
        this.cifNumber = cifNumber;
    }

    public String getNewMpin() {
        return newMpin;
    }

    public void setNewMpin(String newMpin) {
        this.newMpin = newMpin;
    }

    @Override
    public String toString() {
        return "ForgotMpinRequest{" +
                "cifNumber='" + cifNumber + '\'' +
                ", newMpin='" + newMpin + '\'' +
                '}';
    }
}
