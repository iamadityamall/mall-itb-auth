package com.mall.lakshmi.authentication_servcie.dto;

public class DeviceRegistrationRequest {
    private String cifNumber;
    private String imei;
    private String deviceModel;
    private String mobileNumber;
    private String userName;

    public DeviceRegistrationRequest() {
    }

    public DeviceRegistrationRequest(String cifNumber, String imei, String deviceModel, String mobileNumber, String userName) {
        this.cifNumber = cifNumber;
        this.imei = imei;
        this.deviceModel = deviceModel;
        this.mobileNumber = mobileNumber;
        this.userName = userName;
    }

    public String getCifNumber() {
        return cifNumber;
    }

    public void setCifNumber(String cifNumber) {
        this.cifNumber = cifNumber;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "DeviceRegistrationRequest{" +
                "cifNumber='" + cifNumber + '\'' +
                ", imei='" + imei + '\'' +
                ", deviceModel='" + deviceModel + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
