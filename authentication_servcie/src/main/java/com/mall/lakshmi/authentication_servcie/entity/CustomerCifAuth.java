//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_servcie.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CustomerCifAuth extends BaseEntity {
    @Id
    private String cifNumber;
    private boolean isRegistered;

    public CustomerCifAuth(String cifNumber, boolean isRegistered) {
        this.cifNumber = cifNumber;
        this.isRegistered = isRegistered;
    }

    public CustomerCifAuth() {
    }

    public String getCifNumber() {
        return this.cifNumber;
    }

    public void setCifNumber(String cifNumber) {
        this.cifNumber = cifNumber;
    }

    public boolean isRegistered() {
        return this.isRegistered;
    }

    public void setRegistered(boolean registered) {
        this.isRegistered = registered;
    }

    public String toString() {
        return "CustomerCifAuth{, cifNumber='" + this.cifNumber + "', isRegistered=" + this.isRegistered + "}";
    }
}
