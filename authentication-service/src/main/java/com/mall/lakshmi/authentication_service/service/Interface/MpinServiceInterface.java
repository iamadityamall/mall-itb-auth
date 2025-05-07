//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_service.service.Interface;

import com.mall.lakshmi.authentication_service.dto.MpinRequest;
import com.mall.lakshmi.authentication_service.dto.MpinResponse;

public interface MpinServiceInterface {
    MpinResponse registerMpin(MpinRequest mpinRequest);

    void updateMpin(MpinRequest mpinRequest);
}
