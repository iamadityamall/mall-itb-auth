package com.mall.lakshmi.authentication_servcie.service.implementation;

import com.mall.lakshmi.authentication_servcie.dto.DeviceRegistrationRequest;
import com.mall.lakshmi.authentication_servcie.dto.DeviceRegistrationResponse;
import com.mall.lakshmi.authentication_servcie.entity.Client;
import com.mall.lakshmi.authentication_servcie.entity.DeviceRegistration;
import com.mall.lakshmi.authentication_servcie.entity.DeviceRegistrationHistory;
import com.mall.lakshmi.authentication_servcie.repository.ClientRepository;
import com.mall.lakshmi.authentication_servcie.repository.DeviceRegistrationHistoryRepository;
import com.mall.lakshmi.authentication_servcie.repository.DeviceRegistrationRepository;
import com.mall.lakshmi.authentication_servcie.service.Interface.IDeviceRegistrationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class DeviceRegistrationService implements IDeviceRegistrationService {

    private final DeviceRegistrationHistoryRepository deviceRegistrationHistoryRepository;
    private final DeviceRegistrationRepository deviceRegistrationRepository;
    private final ClientRepository clientRepository;

    public DeviceRegistrationService(DeviceRegistrationHistoryRepository deviceRegistrationHistoryRepository, DeviceRegistrationRepository deviceRegistrationRepository, ClientRepository clientRepository) {
        this.deviceRegistrationHistoryRepository = deviceRegistrationHistoryRepository;
        this.deviceRegistrationRepository = deviceRegistrationRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public DeviceRegistrationResponse register(DeviceRegistrationRequest request, String ipAddress) {

        Optional<DeviceRegistration> existing = deviceRegistrationRepository.findByCifNumberAndImei(request.getCifNumber(), request.getImei());

        if (existing.isPresent()) {
            return new DeviceRegistrationResponse("Device already registered.", "DEVICE_EXISTS", LocalDateTime.now());
        }
        // Save active device
        DeviceRegistration device = new DeviceRegistration();

        device.setCifNumber(request.getCifNumber());
        device.setImei(request.getImei());
        device.setDeviceModel(request.getDeviceModel());
        device.setMobileNumber(request.getMobileNumber());
        device.setUserName(request.getUserName());
        device.setIpAddress(ipAddress);
        deviceRegistrationRepository.save(device);

        // Log in history
        DeviceRegistrationHistory history = new DeviceRegistrationHistory();
        history.setCifNumber(request.getCifNumber());
        history.setImei(request.getImei());
        history.setDeviceModel(request.getDeviceModel());
        history.setMobileNumber(request.getMobileNumber());
        history.setUserName(request.getUserName());
        history.setIpAddress(ipAddress);

        deviceRegistrationHistoryRepository.save(history);

        return new DeviceRegistrationResponse("Device registered successfully.", "DEVICE_REGISTERED", LocalDateTime.now());
    }
}
