package com.mall.lakshmi.authentication_servcie.repository;

import com.mall.lakshmi.authentication_servcie.entity.UserMpin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MpinRepository extends JpaRepository<UserMpin, Long> {
    Optional<UserMpin> findByCifNumber(String cifNumber);
}
