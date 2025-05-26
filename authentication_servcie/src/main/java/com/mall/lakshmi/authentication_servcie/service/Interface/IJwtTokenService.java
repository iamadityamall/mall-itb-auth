package com.mall.lakshmi.authentication_servcie.service.Interface;

public interface IJwtTokenService {

    String generateToken(String cifNumber);

    String extractCif(String token);
     boolean isTokenValid(String token);

}
