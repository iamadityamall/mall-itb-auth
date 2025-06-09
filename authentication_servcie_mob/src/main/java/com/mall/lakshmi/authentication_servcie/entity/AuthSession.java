package com.mall.lakshmi.authentication_servcie.entity;

import jakarta.persistence.*;

@Entity
public class AuthSession extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cifNumber;
    private String jwtToken;
    private boolean active;

    @Column(name = "ip_address")
    private String ipAddress;

    public AuthSession() {
    }

    public AuthSession( String cifNumber, String jwtToken, boolean active, String ipAddress) {
        this.cifNumber = cifNumber;
        this.jwtToken = jwtToken;
        this.active = active;
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

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "AuthSession{" +
                "id=" + id +
                ", cifNumber='" + cifNumber + '\'' +
                ", jwtToken='" + jwtToken + '\'' +
                ", active=" + active +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }
}
