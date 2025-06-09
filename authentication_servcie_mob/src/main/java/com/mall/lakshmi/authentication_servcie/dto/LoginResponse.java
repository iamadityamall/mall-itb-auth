package com.mall.lakshmi.authentication_servcie.dto;

public class LoginResponse {
    private String jwt;
    private String userName;

    public LoginResponse() {
    }

    public LoginResponse(String jwt, String userName) {
        this.jwt = jwt;
        this.userName = userName;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "jwt='" + jwt + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
