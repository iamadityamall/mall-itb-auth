//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_servcie.service.Interface;


import com.mall.lakshmi.authentication_servcie.dto.DeviceBindingResponse;
import com.mall.lakshmi.authentication_servcie.dto.RegisterDeviceRequest;
import com.mall.lakshmi.authentication_servcie.dto.RegisterDeviceResponse;

public interface DeviceBindingServiceInterface {
    DeviceBindingResponse checkDeviceBinding(String cifNumber, String deviceId);

    RegisterDeviceResponse registerDevice(RegisterDeviceRequest request);
}
