package com.mall.lakshmi.authentication_servcie.dto;

import java.time.LocalDateTime;

public class ApiResponse <T>{
    private String status;       // "SUCCESS" or "FAILED"
    private String message;
    private T payload;
    private LocalDateTime timeStamp;

    public ApiResponse() {
    }

    public ApiResponse(String status, String message, T payload, LocalDateTime timeStamp) {
        this.status = status;
        this.message = message;
        this.payload = payload;
        this.timeStamp = timeStamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", payload=" + payload +
                ", timeStamp=" + timeStamp +
                '}';
    }
}