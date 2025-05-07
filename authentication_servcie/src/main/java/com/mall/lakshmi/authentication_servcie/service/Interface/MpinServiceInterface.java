//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_servcie.service.Interface;


import com.mall.lakshmi.authentication_servcie.dto.MpinRequest;
import com.mall.lakshmi.authentication_servcie.dto.MpinResponse;

public interface MpinServiceInterface {
    MpinResponse registerMpin(MpinRequest mpinRequest);

    void updateMpin(MpinRequest mpinRequest);
}
