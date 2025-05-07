//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_servcie.repository;


import com.mall.lakshmi.authentication_servcie.entity.CustomerMpin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerMpinRepository extends JpaRepository<CustomerMpin, Long> {
    Optional<CustomerMpin> findByCifNumber(String cifNumber);
}
