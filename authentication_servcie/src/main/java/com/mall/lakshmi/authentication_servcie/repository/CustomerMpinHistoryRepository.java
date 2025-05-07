//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_servcie.repository;


import com.mall.lakshmi.authentication_servcie.entity.CustomerMpinHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMpinHistoryRepository extends JpaRepository<CustomerMpinHistory, Long> {
    List<CustomerMpinHistory> findByCifNumber(String cifNumber);
}
