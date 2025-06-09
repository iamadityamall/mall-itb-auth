package com.mall.lakshmi.authentication_servcie.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientName;
    private String clientCode;
    private String cifNumber;
    private String catchPhrase;

    public Client() {
    }

    public Client(Long id, String clientName, String clientCode, String cifNumber, String catchPhrase) {
        this.id = id;
        this.clientName = clientName;
        this.clientCode = clientCode;
        this.cifNumber = cifNumber;
        this.catchPhrase = catchPhrase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getCifNumber() {
        return cifNumber;
    }

    public void setCifNumber(String cifNumber) {
        this.cifNumber = cifNumber;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", clientCode='" + clientCode + '\'' +
                ", cifNumber='" + cifNumber + '\'' +
                ", catchPhrase='" + catchPhrase + '\'' +
                '}';
    }
}
