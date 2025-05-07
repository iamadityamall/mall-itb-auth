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
        name = "customer_mpin_history"
)
public class CustomerMpinHistory extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String cifNumber;
    private String mpin;
    private boolean active;

    public CustomerMpinHistory() {
    }

    public CustomerMpinHistory(String cifNumber, String mpin, boolean active) {
        this.cifNumber = cifNumber;
        this.mpin = mpin;
        this.active = active;
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

    public String getMpin() {
        return this.mpin;
    }

    public void setMpin(String mpin) {
        this.mpin = mpin;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String toString() {
        return "CustomerMpinHistory{id=" + this.id + ", cifNumber='" + this.cifNumber + "', mpin='" + this.mpin + "', active=" + this.active + "}";
    }
}
