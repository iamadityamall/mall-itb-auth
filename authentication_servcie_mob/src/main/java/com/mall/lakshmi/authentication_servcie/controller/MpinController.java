package com.mall.lakshmi.authentication_servcie.controller;

import com.mall.lakshmi.authentication_servcie.dto.ApiResponse;
import com.mall.lakshmi.authentication_servcie.dto.ChangeMpinRequest;
import com.mall.lakshmi.authentication_servcie.dto.CreateMpinRequest;
import com.mall.lakshmi.authentication_servcie.dto.ForgotMpinRequest;
import com.mall.lakshmi.authentication_servcie.service.Interface.IMpinService;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/auth/mpin")
public class MpinController {

    private final IMpinService mpinService;


    public MpinController(IMpinService mpinService) {
        this.mpinService = mpinService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Object>> createMpin(@RequestBody CreateMpinRequest request) {
        mpinService.createMpin(request);
        ApiResponse<Object> response = new ApiResponse<>("200", "MPIN created successfully.", null, LocalDateTime.now());
        return ResponseEntity.ok(response);
    }

    @PutMapping("/change")
    public ResponseEntity<ApiResponse<Object>> changeMpin(@RequestBody ChangeMpinRequest request) {
        mpinService.changeMpin(request);
        ApiResponse<Object> response = new ApiResponse<>("200", "MPIN changed successfully.", null, LocalDateTime.now());
        return ResponseEntity.ok(response);
    }

    @PutMapping("/reset")
    public ResponseEntity<ApiResponse<Object>> resetMpin(@RequestBody ForgotMpinRequest request) {
        mpinService.resetMpin(request);
        ApiResponse<Object> response = new ApiResponse<>("200", "MPIN reset successfully.", null, LocalDateTime.now());
        return ResponseEntity.ok(response);
    }
}
