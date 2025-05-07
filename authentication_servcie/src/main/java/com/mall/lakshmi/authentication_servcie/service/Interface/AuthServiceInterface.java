//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_servcie.service.Interface;


import com.mall.lakshmi.authentication_servcie.dto.LoginRequest;
import com.mall.lakshmi.authentication_servcie.dto.LoginResponse;

public interface AuthServiceInterface {
    LoginResponse authenticate(LoginRequest loginRequest);
}
