package com.mall.lakshmi.authentication_servcie.repository;

import com.mall.lakshmi.authentication_servcie.entity.DeviceRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeviceRegistrationRepository extends JpaRepository<DeviceRegistration, Long> {
    Optional<DeviceRegistration> findByCifNumberAndImei(String cifNumber, String imei);
}
