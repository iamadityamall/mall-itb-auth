package com.mall.lakshmi.authentication_servcie.controller;

import com.mall.lakshmi.authentication_servcie.dto.ApiResponse;
import com.mall.lakshmi.authentication_servcie.dto.DeviceRegistrationRequest;
import com.mall.lakshmi.authentication_servcie.dto.DeviceRegistrationResponse;
import com.mall.lakshmi.authentication_servcie.service.Interface.IDeviceRegistrationService;
import com.mall.lakshmi.authentication_servcie.util.CommonUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/auth/device")
public class DeviceRegistrationController {

    private final IDeviceRegistrationService service;


    public DeviceRegistrationController(IDeviceRegistrationService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<DeviceRegistrationResponse>> register(@RequestBody DeviceRegistrationRequest request,  HttpServletRequest httpServletRequest) {
        String ip = CommonUtils.getClientIp(httpServletRequest);
        DeviceRegistrationResponse response = service.register(request, ip);
        return ResponseEntity.ok(new ApiResponse<>("200", "Device registered successfully.", response, LocalDateTime.now()));
    }

}
