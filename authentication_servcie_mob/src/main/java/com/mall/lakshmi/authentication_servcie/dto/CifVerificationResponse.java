package com.mall.lakshmi.authentication_servcie.dto;

public class CifVerificationResponse {
    private String status; // SUCCESS or FAILED
    private String clientName;
    private String clientCode;
    private String jwt;
    private String message;
    private Integer attemptsLeft;

    private String cifNumber;

    public CifVerificationResponse() {
    }

    public CifVerificationResponse(String status, String clientName, String clientCode, String jwt, String message, Integer attemptsLeft, String cifNumber) {
        this.status = status;
        this.clientName = clientName;
        this.clientCode = clientCode;
        this.jwt = jwt;
        this.message = message;
        this.attemptsLeft = attemptsLeft;
        this.cifNumber = cifNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getAttemptsLeft() {
        return attemptsLeft;
    }

    public void setAttemptsLeft(Integer attemptsLeft) {
        this.attemptsLeft = attemptsLeft;
    }

    public String getCifNumber() {
        return cifNumber;
    }

    public void setCifNumber(String cifNumber) {
        this.cifNumber = cifNumber;
    }

    @Override
    public String toString() {
        return "CifVerificationResponse{" +
                "status='" + status + '\'' +
                ", clientName='" + clientName + '\'' +
                ", clientCode='" + clientCode + '\'' +
                ", jwt='" + jwt + '\'' +
                ", message='" + message + '\'' +
                ", attemptsLeft=" + attemptsLeft +
                ", cifNumber='" + cifNumber + '\'' +
                '}';
    }
}
