//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_service.repository;

import com.mall.lakshmi.authentication_service.entity.CustomerMpin;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMpinRepository extends JpaRepository<CustomerMpin, Long> {
    Optional<CustomerMpin> findByCifNumber(String cifNumber);
}
