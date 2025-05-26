package com.mall.lakshmi.authentication_servcie.controller;

import com.mall.lakshmi.authentication_servcie.dto.ApiResponse;
import com.mall.lakshmi.authentication_servcie.dto.LoginRequest;
import com.mall.lakshmi.authentication_servcie.dto.LoginResponse;
import com.mall.lakshmi.authentication_servcie.dto.LogoutResponse;
import com.mall.lakshmi.authentication_servcie.service.Interface.IAuthService;
import com.mall.lakshmi.authentication_servcie.util.CommonUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final IAuthService iAuthService;

    public AuthController(IAuthService iAuthService) {
        this.iAuthService = iAuthService;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> loginWithMpin(@RequestBody LoginRequest request, HttpServletRequest httpServletRequest) {
        String ip = CommonUtils.getClientIp(httpServletRequest);
        LoginResponse response = iAuthService.loginWithMpin(request, ip);
        ApiResponse<LoginResponse> apiResponse = new ApiResponse<>(
                "SUCCESS",
                "Login successful. Token issued.",
                response,
                LocalDateTime.now()
        );
        return ResponseEntity.ok(apiResponse);
    }
    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<LogoutResponse>> logout(HttpServletRequest request) {
        String ip = CommonUtils.getClientIp(request);
        String authHeader = request.getHeader("Authorization");
        String token = (authHeader != null && authHeader.startsWith("Bearer ")) ? authHeader.substring(7) : null;

        LogoutResponse response = (LogoutResponse) iAuthService.logout(token, ip);
        ApiResponse<LogoutResponse> apiResponse = new ApiResponse<>(
                "SUCCESS",
                "Logged out successfully.",
                response,
                LocalDateTime.now()
        );
        return ResponseEntity.ok(apiResponse);
    }
}
