package com.mall.lakshmi.authentication_servcie.service.implementation;

import com.mall.lakshmi.authentication_servcie.service.Interface.IJwtTokenService;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

@Service
public class JwtTokenService implements IJwtTokenService {
    private final SecretKey secret = Keys.hmacShaKeyFor("A1b2C3d4E5f6G7h8I9j0K1l2M3n4O5p6".getBytes());
    private final long expirationMs = 30 * 60 * 1000; // 30 minutes for mobile sessions



    public String generateToken(String cifNumber) {
        return Jwts.builder()
                .setSubject(cifNumber)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }


    @Override
    public String extractCif(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    @Override
    public boolean isTokenValid(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
