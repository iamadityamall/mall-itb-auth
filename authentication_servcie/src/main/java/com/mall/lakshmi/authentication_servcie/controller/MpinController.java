package com.mall.lakshmi.authentication_servcie.controller;


import com.mall.lakshmi.authentication_servcie.dto.ApiResponse;
import com.mall.lakshmi.authentication_servcie.dto.MpinRequest;
import com.mall.lakshmi.authentication_servcie.dto.MpinResponse;
import com.mall.lakshmi.authentication_servcie.service.Interface.MpinServiceInterface;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/auth/mpin"})
public class MpinController {
    private final MpinServiceInterface mpinServiceInterface;

    public MpinController(MpinServiceInterface mpinServiceInterface) {
        this.mpinServiceInterface = mpinServiceInterface;
    }

    @PostMapping({"/register"})
    public ResponseEntity<ApiResponse<MpinResponse>> registerMpin(@RequestBody @Valid MpinRequest mpinRequest) {
        MpinResponse response = this.mpinServiceInterface.registerMpin(mpinRequest);
        ApiResponse<MpinResponse> apiResponse = new ApiResponse("Success", "MPIN registered successfully", response, LocalDateTime.now());
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping({"/update"})
    public ResponseEntity<ApiResponse<?>> updateMpin(@RequestBody @Valid MpinRequest mpinRequest) {
        this.mpinServiceInterface.updateMpin(mpinRequest);
        return new ResponseEntity(new ApiResponse("Success", "Mpin updated successfully", (Object)null, LocalDateTime.now()), HttpStatus.OK);
    }
}
