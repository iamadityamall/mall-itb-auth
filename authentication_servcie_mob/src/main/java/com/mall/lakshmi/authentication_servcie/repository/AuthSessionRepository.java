package com.mall.lakshmi.authentication_servcie.repository;

import com.mall.lakshmi.authentication_servcie.entity.AuthSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthSessionRepository extends JpaRepository<AuthSession, Long> {
    Optional<AuthSession> findByJwtToken(String jwtToken);
    void deleteByJwtToken(String jwtToken);
}
