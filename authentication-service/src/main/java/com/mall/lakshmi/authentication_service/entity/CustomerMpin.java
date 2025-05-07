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
        name = "customer_pin"
)
public class CustomerMpin extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String cifNumber;
    private String mpin;

    public CustomerMpin() {
    }

    public CustomerMpin(String cifNumber, String mpin) {
        this.cifNumber = cifNumber;
        this.mpin = mpin;
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

    public String toString() {
        return "CustomerPin{id=" + this.id + ", cifNumber='" + this.cifNumber + "', mpin='" + this.mpin + "'}";
    }
}
