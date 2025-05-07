package com.mall.lakshmi.authentication_servcie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(
		auditorAwareRef = "auditorProvider"
)
public class AuthenticationServcieApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationServcieApplication.class, args);
	}

}
