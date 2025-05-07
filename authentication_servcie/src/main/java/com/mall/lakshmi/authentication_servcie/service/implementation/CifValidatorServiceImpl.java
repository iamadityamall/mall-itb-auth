//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_servcie.service.implementation;


import com.mall.lakshmi.authentication_servcie.dto.ValidateCifResponse;
import com.mall.lakshmi.authentication_servcie.entity.CustomerCifAuth;
import com.mall.lakshmi.authentication_servcie.exception.customExceptions.CifNotFoundException;
import com.mall.lakshmi.authentication_servcie.repository.CustomerCifAuthRepository;
import com.mall.lakshmi.authentication_servcie.service.Interface.CifValidatorServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class CifValidatorServiceImpl implements CifValidatorServiceInterface {
    private final CustomerCifAuthRepository customerCifAuthRepository;

    public CifValidatorServiceImpl(CustomerCifAuthRepository customerCifAuthRepository) {
        this.customerCifAuthRepository = customerCifAuthRepository;
    }

    public ValidateCifResponse validateCif(String cifNumber) {
        CustomerCifAuth customer = (CustomerCifAuth)this.customerCifAuthRepository.findByCifNumber(cifNumber).orElseThrow(() -> {
            return new CifNotFoundException(cifNumber);
        });
        return new ValidateCifResponse(customer.getCifNumber(), customer.isRegistered());
    }
}
