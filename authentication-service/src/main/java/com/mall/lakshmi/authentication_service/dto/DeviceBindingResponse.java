//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_service.dto;

public class DeviceBindingResponse {
    private String cifNumber;
    private String imei;
    private boolean isActive;

    public DeviceBindingResponse() {
    }

    public DeviceBindingResponse(String cifNumber, String imei, boolean isActive) {
        this.cifNumber = cifNumber;
        this.imei = imei;
        this.isActive = isActive;
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

    public void setImei(String Imei) {
        this.imei = this.imei;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setIsActive(boolean isActive) {
    }

    public String toString() {
        return "DeviceBindingResponse{cifNumber='" + this.cifNumber + "', deviceId='" + this.imei + "', isRegistered=" + this.isActive + "}";
    }
}
