package com.mall.lakshmi.authentication_servcie.entity;

import jakarta.persistence.*;

@Entity
public class DeviceRegistrationHistory extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cifNumber;
    private String imei;
    private String deviceModel;
    private String mobileNumber;
    private String userName;

    @Column(name = "ip_address")
    private String ipAddress;

    public DeviceRegistrationHistory() {
    }

    public DeviceRegistrationHistory(Long id, String cifNumber, String imei, String deviceModel, String mobileNumber, String userName, String ipAddress) {
        this.id = id;
        this.cifNumber = cifNumber;
        this.imei = imei;
        this.deviceModel = deviceModel;
        this.mobileNumber = mobileNumber;
        this.userName = userName;
        this.ipAddress = ipAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "DeviceRegistrationHistory{" +
                "id=" + id +
                ", cifNumber='" + cifNumber + '\'' +
                ", imei='" + imei + '\'' +
                ", deviceModel='" + deviceModel + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", userName='" + userName + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }
}
