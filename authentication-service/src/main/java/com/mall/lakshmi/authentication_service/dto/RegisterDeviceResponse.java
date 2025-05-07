//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_service.dto;

import java.time.LocalDateTime;

public class RegisterDeviceResponse {
    private String cifNumber;
    private String imei;
    private String deviceName;
    private LocalDateTime registeredDate;

    public RegisterDeviceResponse() {
    }

    public RegisterDeviceResponse(String cifNumber, String imei, String deviceName, LocalDateTime registeredDate) {
        this.cifNumber = cifNumber;
        this.imei = imei;
        this.deviceName = deviceName;
        this.registeredDate = registeredDate;
    }

    public String getCifNumber() {
        return this.cifNumber;
    }

    public void setCifNumber(String cifNumber) {
        this.cifNumber = cifNumber;
    }

    public String getImei() {
        return this.imei;
    }

    public void setDeviceId(String imei) {
        this.imei = imei;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public LocalDateTime getRegisteredDate() {
        return this.registeredDate;
    }

    public void setRegisteredDate(LocalDateTime registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String toString() {
        String var10000 = this.cifNumber;
        return "RegisterDeviceResponse{cifNumber='" + var10000 + "', deviceId='" + this.imei + "', deviceName='" + this.deviceName + "', registeredDate=" + String.valueOf(this.registeredDate) + "}";
    }
}
