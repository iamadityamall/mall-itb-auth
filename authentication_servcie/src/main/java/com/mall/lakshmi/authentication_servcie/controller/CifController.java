package com.mall.lakshmi.authentication_servcie.controller;

import com.mall.lakshmi.authentication_servcie.dto.ApiResponse;
import com.mall.lakshmi.authentication_servcie.dto.ValidateCifRequest;
import com.mall.lakshmi.authentication_servcie.dto.ValidateCifResponse;
import com.mall.lakshmi.authentication_servcie.entity.CustomerCifAuth;
import com.mall.lakshmi.authentication_servcie.repository.CustomerCifAuthRepository;
import com.mall.lakshmi.authentication_servcie.service.Interface.CifValidatorServiceInterface;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/auth/cif"})
public class CifController {
    private final CifValidatorServiceInterface cifValidatorServiceInterface;
    private final CustomerCifAuthRepository customerCifAuthRepository;

    public CifController(CifValidatorServiceInterface cifValidatorServiceInterface, CustomerCifAuthRepository customerCifAuthRepository) {
        this.cifValidatorServiceInterface = cifValidatorServiceInterface;
        this.customerCifAuthRepository = customerCifAuthRepository;
    }

    @PostMapping({"/validate"})
    public ResponseEntity<ApiResponse<ValidateCifResponse>> validateCif(@RequestBody @Valid ValidateCifRequest validateCifRequest) {
        ValidateCifResponse response = this.cifValidatorServiceInterface.validateCif(validateCifRequest.getCifNumber());
        return ResponseEntity.ok(new ApiResponse("Success", "Cif validated", response, LocalDateTime.now()));
    }

    @PostMapping({"/register"})
    public ResponseEntity<ApiResponse<?>> regiserCif(@RequestBody @Valid ValidateCifResponse response) {
        CustomerCifAuth cifAuth = new CustomerCifAuth();
        cifAuth.setCifNumber(response.getCifNumber());
        cifAuth.setRegistered(false);
        return ResponseEntity.ok(new ApiResponse("Success", "created", (CustomerCifAuth)this.customerCifAuthRepository.save(cifAuth), LocalDateTime.now()));
    }
}