//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_service.service.Interface;

import com.mall.lakshmi.authentication_service.dto.LoginRequest;
import com.mall.lakshmi.authentication_service.dto.LoginResponse;

public interface AuthServiceInterface {
    LoginResponse authenticate(LoginRequest loginRequest);
}
