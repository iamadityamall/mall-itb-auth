package com.mall.lakshmi.authentication_servcie.dto;

import jakarta.persistence.Column;

public class LoginRequest {
    private String cifNumber;
    private String mpin;

    @Column(name = "ip_address")
    private String ipAddress;

    public LoginRequest() {
    }

    public LoginRequest(String cifNumber, String mpin, String ipAddress) {
        this.cifNumber = cifNumber;
        this.mpin = mpin;
        this.ipAddress = ipAddress;
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

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "cifNumber='" + cifNumber + '\'' +
                ", mpin='" + mpin + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }
}
