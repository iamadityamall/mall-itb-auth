//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_service.service.implementation;

import com.mall.lakshmi.authentication_service.dto.LoginRequest;
import com.mall.lakshmi.authentication_service.dto.LoginResponse;
import com.mall.lakshmi.authentication_service.entity.CustomerMpin;
import com.mall.lakshmi.authentication_service.exception.customExceptions.MpinMismatchException;
import com.mall.lakshmi.authentication_service.repository.CustomerMpinRepository;
import com.mall.lakshmi.authentication_service.service.Interface.AuthServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthServiceInterface {
    private final CustomerMpinRepository customerMpinRepository;

    public AuthServiceImpl(CustomerMpinRepository customerMpinRepository) {
        this.customerMpinRepository = customerMpinRepository;
    }

    public LoginResponse authenticate(LoginRequest request) {
        CustomerMpin mpin = (CustomerMpin)this.customerMpinRepository.findByCifNumber(request.getCifNumber()).orElseThrow(() -> {
            return new MpinMismatchException("MPIN not found for CIF: " + request.getCifNumber());
        });
        if (!mpin.getMpin().equals(request.getMpin())) {
            throw new MpinMismatchException("Invalid MPIN for CIF: " + request.getCifNumber());
        } else {
            return new LoginResponse(request.getCifNumber(), true, "Login successful");
        }
    }
}
