//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_service.service.implementation;

import com.mall.lakshmi.authentication_service.dto.DeviceBindingResponse;
import com.mall.lakshmi.authentication_service.dto.RegisterDeviceRequest;
import com.mall.lakshmi.authentication_service.dto.RegisterDeviceResponse;
import com.mall.lakshmi.authentication_service.entity.CustomerCifAuth;
import com.mall.lakshmi.authentication_service.entity.DeviceBinding;
import com.mall.lakshmi.authentication_service.entity.DeviceHistory;
import com.mall.lakshmi.authentication_service.repository.CustomerCifAuthRepository;
import com.mall.lakshmi.authentication_service.repository.DeviceBindingRepository;
import com.mall.lakshmi.authentication_service.repository.DeviceHistoryRepository;
import com.mall.lakshmi.authentication_service.service.Interface.DeviceBindingServiceInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class DeviceBindingServiceImpl implements DeviceBindingServiceInterface {
    private final DeviceBindingRepository deviceBindingRepository;
    private final DeviceHistoryRepository deviceHistoryRepository;
    private final CustomerCifAuthRepository cifAuthRepository;

    public DeviceBindingServiceImpl(DeviceBindingRepository deviceBindingRepository, DeviceHistoryRepository deviceHistoryRepository, CustomerCifAuthRepository cifAuthRepository) {
        this.deviceBindingRepository = deviceBindingRepository;
        this.deviceHistoryRepository = deviceHistoryRepository;
        this.cifAuthRepository = cifAuthRepository;
    }

    public DeviceBindingResponse checkDeviceBinding(String cifNumber, String imei) {
        Optional<DeviceBinding> deviceBindingOptional = this.deviceBindingRepository.findByCifNumberAndImei(cifNumber, imei);
        boolean isActive = (Boolean)deviceBindingOptional.map(DeviceBinding::isActive).orElse(false);
        if (isActive) {
            this.deviceHistoryRepository.save(new DeviceHistory(cifNumber, imei));
        }

        return new DeviceBindingResponse(cifNumber, imei, isActive);
    }

    public RegisterDeviceResponse registerDevice(RegisterDeviceRequest request) {
        List<DeviceBinding> existingBinding = (List)this.deviceBindingRepository.findByCifNumber(request.getCifNumber()).orElse((List<DeviceBinding>) null);
        if (existingBinding != null) {
            this.setIsActiveOfAllDeviceBindingEntriesToFalse(existingBinding);
        }

        if (existingBinding.isEmpty()) {
            Optional<CustomerCifAuth> cif = this.cifAuthRepository.findByCifNumber(request.getCifNumber());
            System.out.println("cif: " + ((CustomerCifAuth)cif.get()).toString());
            ((CustomerCifAuth)cif.get()).setRegistered(true);
            this.cifAuthRepository.save((CustomerCifAuth)cif.get());
        }

        DeviceBinding newBinding = new DeviceBinding();
        newBinding.setCifNumber(request.getCifNumber());
        newBinding.setImei(request.getImei());
        newBinding.setActive(true);
        newBinding.setDeviceName(request.getDeviceName());
        this.deviceBindingRepository.save(newBinding);
        DeviceHistory deviceHistory = new DeviceHistory();
        deviceHistory.setCifNumber(request.getCifNumber());
        deviceHistory.setImei(request.getImei());
        this.deviceHistoryRepository.save(deviceHistory);
        return new RegisterDeviceResponse(newBinding.getCifNumber(), newBinding.getImei(), newBinding.getDeviceName(), newBinding.getCreatedAt());
    }

    private void setIsActiveOfAllDeviceBindingEntriesToFalse(List<DeviceBinding> listOfDeviceBinding) {
        listOfDeviceBinding.forEach((singleDeviceBindingRecord) -> {
            singleDeviceBindingRecord.setActive(false);
            this.deviceBindingRepository.save(singleDeviceBindingRecord);
        });
    }
}
