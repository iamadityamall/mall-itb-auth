package com.mall.lakshmi.authentication_service.controller;

import com.mall.lakshmi.authentication_service.dto.ApiResponse;
import com.mall.lakshmi.authentication_service.dto.DeviceBindingRequest;
import com.mall.lakshmi.authentication_service.dto.DeviceBindingResponse;
import com.mall.lakshmi.authentication_service.dto.RegisterDeviceRequest;
import com.mall.lakshmi.authentication_service.dto.RegisterDeviceResponse;
import com.mall.lakshmi.authentication_service.service.Interface.DeviceBindingServiceInterface;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/auth/device"})
public class DeviceBindingController {
    private final DeviceBindingServiceInterface deviceBindingServiceInterface;

    public DeviceBindingController(DeviceBindingServiceInterface deviceBindingServiceInterface) {
        this.deviceBindingServiceInterface = deviceBindingServiceInterface;
    }

    @PostMapping({"/check-binding"})
    public ResponseEntity<ApiResponse<DeviceBindingResponse>> checkDeviceBinding(@RequestBody @Valid DeviceBindingRequest request) {
        DeviceBindingResponse response = this.deviceBindingServiceInterface.checkDeviceBinding(request.getCifNumber(), request.getImei());
        String message = response.isActive() ? "Device already registered" : "Device not registered";
        return ResponseEntity.ok(new ApiResponse("SUCCESS", message, response, LocalDateTime.now()));
    }

    @PostMapping({"/register"})
    public ResponseEntity<ApiResponse<RegisterDeviceResponse>> registerDevice(@RequestBody @Valid RegisterDeviceRequest request) {
        RegisterDeviceResponse response = this.deviceBindingServiceInterface.registerDevice(request);
        ApiResponse<RegisterDeviceResponse> apiResponse = new ApiResponse("Success", "Device registered successfullu", response, LocalDateTime.now());
        return ResponseEntity.ok(apiResponse);
    }
}
