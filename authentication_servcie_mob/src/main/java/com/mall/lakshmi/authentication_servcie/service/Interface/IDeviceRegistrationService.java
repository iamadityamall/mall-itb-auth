package com.mall.lakshmi.authentication_servcie.service.Interface;

import com.mall.lakshmi.authentication_servcie.dto.DeviceRegistrationRequest;
import com.mall.lakshmi.authentication_servcie.dto.DeviceRegistrationResponse;

public interface IDeviceRegistrationService {
    DeviceRegistrationResponse register(DeviceRegistrationRequest request, String ipAddress);
}
