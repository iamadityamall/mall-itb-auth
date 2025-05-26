package com.mall.lakshmi.authentication_servcie.service.Interface;

import com.mall.lakshmi.authentication_servcie.dto.LoginRequest;
import com.mall.lakshmi.authentication_servcie.dto.LoginResponse;

public interface IAuthService {
    LoginResponse loginWithMpin(LoginRequest request, String ipAddress);
    Object logout(String jwtToken,  String ipAddress);
}
