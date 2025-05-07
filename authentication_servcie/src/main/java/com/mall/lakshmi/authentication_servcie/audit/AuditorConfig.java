package com.mall.lakshmi.authentication_servcie.audit;

import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

@Configuration
public class AuditorConfig {
    public AuditorConfig() {
    }

    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> {
            return Optional.of("SYSTEM");
        };
    }
}