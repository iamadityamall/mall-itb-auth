package com.mall.lakshmi.authentication_servcie.dto;

public class ChangeMpinRequest {

    private String cifNumber;
    private String oldMpin;
    private String newMpin;

    public ChangeMpinRequest() {
    }

    public ChangeMpinRequest(String cifNumber, String oldMpin, String newMpin) {
        this.cifNumber = cifNumber;
        this.oldMpin = oldMpin;
        this.newMpin = newMpin;
    }

    public String getCifNumber() {
        return cifNumber;
    }

    public void setCifNumber(String cifNumber) {
        this.cifNumber = cifNumber;
    }

    public String getOldMpin() {
        return oldMpin;
    }

    public void setOldMpin(String oldMpin) {
        this.oldMpin = oldMpin;
    }

    public String getNewMpin() {
        return newMpin;
    }

    public void setNewMpin(String newMpin) {
        this.newMpin = newMpin;
    }

    @Override
    public String toString() {
        return "ChangeMpinRequest{" +
                "cifNumber='" + cifNumber + '\'' +
                ", oldMpin='" + oldMpin + '\'' +
                ", newMpin='" + newMpin + '\'' +
                '}';
    }
}
