package com.mall.lakshmi.authentication_servcie.dto;

import java.time.LocalDateTime;

public class ErrorResponse {
    private int statusCode;
    private String errorCode;
    private String detail;

    public ErrorResponse(int statusCode, String errorCode, String detail) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.detail = detail;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "statusCode=" + statusCode +
                ", errorCode='" + errorCode + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
