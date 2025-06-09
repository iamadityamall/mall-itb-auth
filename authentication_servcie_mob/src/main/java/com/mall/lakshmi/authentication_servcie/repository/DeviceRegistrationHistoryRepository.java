package com.mall.lakshmi.authentication_servcie.repository;

import com.mall.lakshmi.authentication_servcie.entity.DeviceRegistrationHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRegistrationHistoryRepository extends JpaRepository<DeviceRegistrationHistory, Long> {
}
