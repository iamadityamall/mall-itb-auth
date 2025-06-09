package com.mall.lakshmi.authentication_servcie.service.Interface;

import com.mall.lakshmi.authentication_servcie.dto.ChangeMpinRequest;
import com.mall.lakshmi.authentication_servcie.dto.CreateMpinRequest;
import com.mall.lakshmi.authentication_servcie.dto.ForgotMpinRequest;

public interface IMpinService {
    void createMpin(CreateMpinRequest request);
    void changeMpin(ChangeMpinRequest request);
    void resetMpin(ForgotMpinRequest request);
}
