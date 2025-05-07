//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "device_history"
)
public class DeviceHistory extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            name = "cif_number",
            nullable = false
    )
    private String cifNumber;
    @Column(
            name = "imei",
            nullable = false
    )
    private String imei;

    public DeviceHistory() {
    }

    public DeviceHistory(String cifNumber, String imei) {
        this.cifNumber = cifNumber;
        this.imei = imei;
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

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String toString() {
        return "DeviceHistory{id=" + this.id + ", cifNumber='" + this.cifNumber + "', imei='" + this.imei + "'}";
    }
}
