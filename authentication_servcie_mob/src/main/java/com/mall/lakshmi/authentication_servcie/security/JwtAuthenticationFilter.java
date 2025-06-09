package com.mall.lakshmi.authentication_servcie.security;

import com.mall.lakshmi.authentication_servcie.entity.AuthSession;
import com.mall.lakshmi.authentication_servcie.exception.custom.auth.InvalidSessionException;
import com.mall.lakshmi.authentication_servcie.repository.AuthSessionRepository;
import com.mall.lakshmi.authentication_servcie.service.implementation.JwtTokenService;
import com.mall.lakshmi.authentication_servcie.util.ErrorResponseWriter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenService jwtTokenService;

    private final AuthSessionRepository authSessionRepository;

    public JwtAuthenticationFilter(JwtTokenService jwtTokenService, AuthSessionRepository authSessionRepository) {
        this.jwtTokenService = jwtTokenService;
        this.authSessionRepository = authSessionRepository;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        final String jwt = authHeader.substring(7);

        try {
            if (!jwtTokenService.isTokenValid(jwt)) {
                throw new InvalidSessionException("Token is expired or malformed.");
            }

            authSessionRepository.findByJwtToken(jwt)
                    .filter(AuthSession::isActive)
                    .orElseThrow(() -> new InvalidSessionException("Session is invalid or user is logged out."));

            String cif = jwtTokenService.extractCif(jwt);
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(cif, null, Collections.emptyList());
            auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(auth);

            filterChain.doFilter(request, response);

        } catch (InvalidSessionException ex) {
            ErrorResponseWriter.write(response, 401, "INVALID_SESSION", ex.getMessage());
            return;
        }
    }

}
