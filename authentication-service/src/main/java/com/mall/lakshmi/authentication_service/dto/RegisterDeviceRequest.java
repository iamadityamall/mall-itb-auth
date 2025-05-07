//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_service.dto;

import jakarta.validation.constraints.NotBlank;

public class RegisterDeviceRequest {
    private @NotBlank(
            message = "CIF number cannot be blank"
    ) String cifNumber;
    private @NotBlank(
            message = "IMEI number cannot be blank"
    ) String imei;
    private @NotBlank(
            message = "IMEI number cannot be blank"
    ) String deviceName;

    public RegisterDeviceRequest() {
    }

    public RegisterDeviceRequest(String cifNumber, String imei, String deviceName) {
        this.cifNumber = cifNumber;
        this.imei = imei;
        this.deviceName = deviceName;
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

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String toString() {
        return "RegisterDeviceRequest{cifNumber='" + this.cifNumber + "', deviceId='" + this.imei + "', deviceName='" + this.deviceName + "'}";
    }
}
