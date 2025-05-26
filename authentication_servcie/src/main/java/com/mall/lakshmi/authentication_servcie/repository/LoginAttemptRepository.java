package com.mall.lakshmi.authentication_servcie.repository;

import com.mall.lakshmi.authentication_servcie.entity.Client;
import com.mall.lakshmi.authentication_servcie.entity.LoginAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginAttemptRepository extends JpaRepository<LoginAttempt, Long> {
    long countByCifAndStatus(String cifNumber, String status);

}
