package com.mall.lakshmi.authentication_servcie.service.Interface;

import com.mall.lakshmi.authentication_servcie.dto.CifVerificationRequest;
import com.mall.lakshmi.authentication_servcie.dto.CifVerificationResponse;

public interface ICifVerificationService {
    CifVerificationResponse verify(CifVerificationRequest request, String ipAddress);
}
