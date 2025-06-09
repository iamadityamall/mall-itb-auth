package com.mall.lakshmi.authentication_servcie.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class LoginAttempt extends Auditable{
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cif;
    private String catchPhrase;
    private String imei;
    private String deviceModel;
    private String mobileNumber;
    private String status;
    private int attemptCount;
    @Column(name = "ip_address")
    private String ipAddress;
    private LocalDateTime timestamp;

    public LoginAttempt() {
    }

    public LoginAttempt(Long id, String cif, String catchPhrase, String imei, String deviceModel, String mobileNumber, String status, int attemptCount, String ipAddress, LocalDateTime timestamp) {
        this.id = id;
        this.cif = cif;
        this.catchPhrase = catchPhrase;
        this.imei = imei;
        this.deviceModel = deviceModel;
        this.mobileNumber = mobileNumber;
        this.status = status;
        this.attemptCount = attemptCount;
        this.ipAddress = ipAddress;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public void setAttemptCount(int attemptCount) {
        this.attemptCount = attemptCount;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "LoginAttempt{" +
                "id=" + id +
                ", cif='" + cif + '\'' +
                ", catchPhrase='" + catchPhrase + '\'' +
                ", imei='" + imei + '\'' +
                ", deviceModel='" + deviceModel + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", status='" + status + '\'' +
                ", attemptCount=" + attemptCount +
                ", ipAddress='" + ipAddress + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
