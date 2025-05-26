package com.mall.lakshmi.authentication_servcie.service.implementation;

import com.mall.lakshmi.authentication_servcie.dto.CifVerificationRequest;
import com.mall.lakshmi.authentication_servcie.dto.LoginRequest;
import com.mall.lakshmi.authentication_servcie.dto.LoginResponse;
import com.mall.lakshmi.authentication_servcie.dto.LogoutResponse;
import com.mall.lakshmi.authentication_servcie.entity.AuthSession;
import com.mall.lakshmi.authentication_servcie.entity.Client;
import com.mall.lakshmi.authentication_servcie.entity.UserMpin;
import com.mall.lakshmi.authentication_servcie.exception.custom.auth.InvalidSessionException;
import com.mall.lakshmi.authentication_servcie.exception.custom.cif.ClientNotFoundException;
import com.mall.lakshmi.authentication_servcie.exception.custom.mpin.InvalidMpinException;
import com.mall.lakshmi.authentication_servcie.exception.custom.mpin.MpinNotFoundException;
import com.mall.lakshmi.authentication_servcie.repository.AuthSessionRepository;
import com.mall.lakshmi.authentication_servcie.repository.ClientRepository;
import com.mall.lakshmi.authentication_servcie.repository.MpinRepository;
import com.mall.lakshmi.authentication_servcie.service.Interface.IAuthService;
import com.mall.lakshmi.authentication_servcie.service.Interface.IJwtTokenService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthService implements IAuthService {

    private final ClientRepository clientRepository;
    private final MpinRepository mpinRepository;
    private final AuthSessionRepository authSessionRepository;
    private final IJwtTokenService jwtTokenService;

    public AuthService(ClientRepository clientRepository, MpinRepository mpinRepository, AuthSessionRepository authSessionRepository, IJwtTokenService jwtTokenService) {
        this.clientRepository = clientRepository;
        this.mpinRepository = mpinRepository;
        this.authSessionRepository = authSessionRepository;
        this.jwtTokenService = jwtTokenService;
    }

    @Override
    public LoginResponse loginWithMpin(LoginRequest request, String ipAddress) {

        UserMpin mpin = mpinRepository.findByCifNumber(request.getCifNumber()).orElseThrow(() -> new MpinNotFoundException("MPIN not found"));
        if (!BCrypt.checkpw(request.getMpin(), mpin.getHashedMpin())) {
            throw new InvalidMpinException("Invalid MPIN");
        }

        Client client = clientRepository.findByCifNumber(request.getCifNumber()).orElseThrow(() -> new ClientNotFoundException("Client not found"));
        String token = jwtTokenService.generateToken(request.getCifNumber());

        AuthSession session = new AuthSession();
        session.setIpAddress(ipAddress);
        session.setCifNumber(request.getCifNumber());
        session.setJwtToken(token);
        session.setActive(true);
        authSessionRepository.save(session);
        return new LoginResponse(token, client.getClientName());
    }

    @Override
    public LogoutResponse logout(String jwtToken, String ipAddress) {
        AuthSession session = authSessionRepository.findByJwtToken(jwtToken.replace("Bearer ", ""))
                .orElseThrow(() -> new InvalidSessionException("Invalid Session"));
        session.setActive(false);
        session.setIpAddress(ipAddress);
        authSessionRepository.save(session);
        return new LogoutResponse("Logged out successfully.", LocalDateTime.now());
    }
}
