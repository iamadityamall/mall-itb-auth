package com.mall.lakshmi.authentication_servcie.audit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
public class AuditorAwareConfig  {

    @Bean
    public AuditorAware<String> auditorProvider() {
        System.out.println("Audit triggered============================================================");
        return () -> Optional.of("SYSTEM"); // Replace with SecurityContextHolder later
    }

}
