//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "audit_log"
)
public class AuditLog extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String cifNumber;
    private String imei;
    private String action;
    private String status;

    public AuditLog() {
    }

    public AuditLog(String cifNumber, String imei, String action, String status) {
        this.cifNumber = cifNumber;
        this.imei = imei;
        this.action = action;
        this.status = status;
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

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return "AuditLog{id=" + this.id + ", cifNumber='" + this.cifNumber + "', imei='" + this.imei + "', action='" + this.action + "', status='" + this.status + "'}";
    }
}
