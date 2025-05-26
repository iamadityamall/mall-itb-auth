package com.mall.lakshmi.authentication_servcie.dto;

public class CifVerificationRequest {
    private String cifNumber;
    private String catchPhrase;
    private String imei;
    private String deviceModel;
    private String mobileNumber;

    public CifVerificationRequest() {
    }

    public CifVerificationRequest(String cifNumber, String catchPhrase, String imei, String deviceModel, String mobileNumber) {
        this.cifNumber = cifNumber;
        this.catchPhrase = catchPhrase;
        this.imei = imei;
        this.deviceModel = deviceModel;
        this.mobileNumber = mobileNumber;
    }

    public String getCifNumber() {
        return cifNumber;
    }

    public void setCifNumber(String cifNumber) {
        this.cifNumber = cifNumber;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
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

    @Override
    public String toString() {
        return "CifVerificationRequest{" +
                "cifNumber='" + cifNumber + '\'' +
                ", catchPhrase='" + catchPhrase + '\'' +
                ", imei='" + imei + '\'' +
                ", deviceModel='" + deviceModel + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}
