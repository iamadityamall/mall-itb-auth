package com.mall.lakshmi.authentication_servcie.dto;

import java.time.LocalDateTime;

public class ApiResponse<T> {
    private String status;
    private String message;
    private T payload;
    private LocalDateTime timeStamp;

    public ApiResponse(String status, String message, T payload, LocalDateTime timeStamp) {
        this.status = status;
        this.message = message;
        this.payload = payload;
        this.timeStamp = timeStamp;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getPayload() {
        return this.payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public LocalDateTime getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String toString() {
        String var10000 = this.status;
        return "ApiResponse{status='" + var10000 + "', message='" + this.message + "', payload=" + String.valueOf(this.payload) + ", timeStamp=" + String.valueOf(this.timeStamp) + "}";
    }
}
