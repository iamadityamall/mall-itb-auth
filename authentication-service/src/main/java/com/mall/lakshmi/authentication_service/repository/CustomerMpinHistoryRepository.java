//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_service.repository;

import com.mall.lakshmi.authentication_service.entity.CustomerMpinHistory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMpinHistoryRepository extends JpaRepository<CustomerMpinHistory, Long> {
    List<CustomerMpinHistory> findByCifNumber(String cifNumber);
}
