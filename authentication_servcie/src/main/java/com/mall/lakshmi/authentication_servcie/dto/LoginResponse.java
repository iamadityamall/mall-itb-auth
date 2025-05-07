//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_servcie.dto;

public class LoginResponse {
    private String cifNumber;
    private boolean loginSuccess;
    private String message;

    public LoginResponse() {
    }

    public LoginResponse(String cifNumber, boolean loginSuccess, String message) {
        this.cifNumber = cifNumber;
        this.loginSuccess = loginSuccess;
        this.message = message;
    }

    public String getCifNumber() {
        return this.cifNumber;
    }

    public void setCifNumber(String cifNumber) {
        this.cifNumber = cifNumber;
    }

    public boolean isLoginSuccess() {
        return this.loginSuccess;
    }

    public void setLoginSuccess(boolean loginSuccess) {
        this.loginSuccess = loginSuccess;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return "LoginResponse{cifNumber='" + this.cifNumber + "', loginSuccess=" + this.loginSuccess + ", message='" + this.message + "'}";
    }
}
