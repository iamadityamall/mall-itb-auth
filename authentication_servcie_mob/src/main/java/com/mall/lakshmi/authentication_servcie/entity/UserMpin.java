package com.mall.lakshmi.authentication_servcie.entity;

import jakarta.persistence.*;

@Entity
public class UserMpin extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cifNumber;

    @Column(nullable = false)
    private String hashedMpin;

    public UserMpin() {
    }

    public UserMpin(Long id, String cifNumber, String hashedMpin) {
        this.id = id;
        this.cifNumber = cifNumber;
        this.hashedMpin = hashedMpin;
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

    public String getHashedMpin() {
        return hashedMpin;
    }

    public void setHashedMpin(String hashedMpin) {
        this.hashedMpin = hashedMpin;
    }

    @Override
    public String toString() {
        return "UserMpin{" +
                "id=" + id +
                ", cifNumber='" + cifNumber + '\'' +
                ", hashedMpin='" + hashedMpin + '\'' +
                '}';
    }
}
