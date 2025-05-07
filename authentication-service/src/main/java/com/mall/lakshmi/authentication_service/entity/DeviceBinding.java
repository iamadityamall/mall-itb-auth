//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DeviceBinding extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String cifNumber;
    private String imei;
    private boolean isActive;
    private String deviceName;

    public DeviceBinding() {
    }

    public DeviceBinding(Long id, String cifNumber, String imei, boolean isActive, String deviceName) {
        this.id = id;
        this.cifNumber = cifNumber;
        this.imei = imei;
        this.isActive = isActive;
        this.deviceName = deviceName;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isActive() {
        return this.isActive;
    }

    public void setRegistered(boolean isActive) {
        this.isActive = isActive;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public String toString() {
        return "DeviceBinding{id=" + this.id + ", cifNumber='" + this.cifNumber + "', imei='" + this.imei + "', isActive=" + this.isActive + ", deviceName='" + this.deviceName + "'}";
    }
}
