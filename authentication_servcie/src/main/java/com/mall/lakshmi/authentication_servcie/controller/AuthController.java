package com.mall.lakshmi.authentication_servcie.controller;

import java.time.LocalDateTime;

import com.mall.lakshmi.authentication_servcie.dto.ApiResponse;
import com.mall.lakshmi.authentication_servcie.dto.LoginRequest;
import com.mall.lakshmi.authentication_servcie.dto.LoginResponse;
import com.mall.lakshmi.authentication_servcie.exception.customExceptions.MpinMismatchException;
import com.mall.lakshmi.authentication_servcie.service.Interface.AuditServiceInterface;
import com.mall.lakshmi.authentication_servcie.service.Interface.AuthServiceInterface;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/auth"})
public class AuthController {
    private final AuthServiceInterface authServiceInterface;
    private final AuditServiceInterface auditServiceInterface;

    public AuthController(AuthServiceInterface authServiceInterface, AuditServiceInterface auditServiceInterface) {
        this.authServiceInterface = authServiceInterface;
        this.auditServiceInterface = auditServiceInterface;
    }

    @PostMapping({"/login"})
    public ResponseEntity<ApiResponse<LoginResponse>> loginWithMpin(@RequestBody @Valid LoginRequest loginRequest) {
        try {
            LoginResponse response = this.authServiceInterface.authenticate(loginRequest);
            this.auditServiceInterface.log(loginRequest.getCifNumber(), loginRequest.getImei(), "LOGIN", "SUCCESS");
            return ResponseEntity.ok(new ApiResponse("Success", "Login successful", response, LocalDateTime.now()));
        } catch (MpinMismatchException var3) {
            this.auditServiceInterface.log(loginRequest.getCifNumber(), loginRequest.getImei(), "LOGIN", "FAILURE");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse("Failure", "Invalid MPIN", (Object)null, LocalDateTime.now()));
        }
    }
}
