//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_service.service.Interface;

import com.mall.lakshmi.authentication_service.dto.DeviceBindingResponse;
import com.mall.lakshmi.authentication_service.dto.RegisterDeviceRequest;
import com.mall.lakshmi.authentication_service.dto.RegisterDeviceResponse;

public interface DeviceBindingServiceInterface {
    DeviceBindingResponse checkDeviceBinding(String cifNumber, String deviceId);

    RegisterDeviceResponse registerDevice(RegisterDeviceRequest request);
}
