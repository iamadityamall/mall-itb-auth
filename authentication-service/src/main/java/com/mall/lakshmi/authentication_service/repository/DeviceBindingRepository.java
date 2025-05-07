//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_service.repository;

import com.mall.lakshmi.authentication_service.entity.DeviceBinding;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceBindingRepository extends JpaRepository<DeviceBinding, Long> {
    Optional<DeviceBinding> findByCifNumberAndImei(String cifNumber, String imei);

    Optional<List<DeviceBinding>> findByCifNumber(String cifNumber);
}
