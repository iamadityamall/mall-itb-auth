package com.mall.lakshmi.authentication_servcie.dto;

import java.time.LocalDateTime;

public class DeviceRegistrationResponse {
    private String message;
    private String messageCode;
    private LocalDateTime timeStamp;

    public DeviceRegistrationResponse(String message, String messageCode, LocalDateTime timeStamp) {
        this.message = message;
        this.messageCode = messageCode;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "DeviceRegistrationResponse{" +
                "message='" + message + '\'' +
                ", messageCode='" + messageCode + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
