//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_servcie.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class DeviceBindingRequest {
    private @NotBlank(
            message = "CIF number cannot be blank"
    ) @Pattern(
            regexp = "CIF\\d{5,10}",
            message = "CIF number must start with 'CIF' followed by 5-10 digits"
    ) String cifNumber;
    private @NotBlank(
            message = "IMEI cannot be blank"
    ) String imei;

    public DeviceBindingRequest() {
    }

    public DeviceBindingRequest(String cifNumber, String imei) {
        this.cifNumber = cifNumber;
        this.imei = imei;
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

    public void setImei(String deviceId) {
        this.imei = deviceId;
    }

    public String toString() {
        return "DeviceBindingRequest{cifNumber='" + this.cifNumber + "', deviceId='" + this.imei + "'}";
    }
}
