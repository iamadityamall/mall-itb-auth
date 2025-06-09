package com.mall.lakshmi.authentication_servcie.controller;

import com.mall.lakshmi.authentication_servcie.dto.ApiResponse;
import com.mall.lakshmi.authentication_servcie.dto.CifVerificationRequest;
import com.mall.lakshmi.authentication_servcie.dto.CifVerificationResponse;
import com.mall.lakshmi.authentication_servcie.service.Interface.ICifVerificationService;
import com.mall.lakshmi.authentication_servcie.util.CommonUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/auth/cif")
public class CifVerifcationController {

    private final ICifVerificationService service;

    public CifVerifcationController(ICifVerificationService service) {
        this.service = service;
    }

    @PostMapping("/verify")
    public ResponseEntity<ApiResponse<CifVerificationResponse>> verfiy(@RequestBody CifVerificationRequest request, HttpServletRequest httpServletRequest) {
        String ip = CommonUtils.getClientIp(httpServletRequest);
        CifVerificationResponse response = service.verify(request, ip);
        ApiResponse<CifVerificationResponse> apiResponse = new ApiResponse<>(
                response.getStatus(),
                response.getMessage(),
                response,
                LocalDateTime.now()
        );
        return ResponseEntity.ok(apiResponse);
    }

}
