package com.mall.lakshmi.authentication_servcie.service.implementation;

import com.mall.lakshmi.authentication_servcie.dto.CifVerificationRequest;
import com.mall.lakshmi.authentication_servcie.dto.CifVerificationResponse;
import com.mall.lakshmi.authentication_servcie.entity.AuthSession;
import com.mall.lakshmi.authentication_servcie.entity.Client;
import com.mall.lakshmi.authentication_servcie.entity.LoginAttempt;
import com.mall.lakshmi.authentication_servcie.exception.custom.cif.ClientNotFoundException;
import com.mall.lakshmi.authentication_servcie.exception.custom.cif.InvalidCatchPhraseException;
import com.mall.lakshmi.authentication_servcie.exception.custom.cif.LoginAttemptLimitExceededException;
import com.mall.lakshmi.authentication_servcie.repository.AuthSessionRepository;
import com.mall.lakshmi.authentication_servcie.repository.ClientRepository;
import com.mall.lakshmi.authentication_servcie.repository.LoginAttemptRepository;
import com.mall.lakshmi.authentication_servcie.service.Interface.ICifVerificationService;
import com.mall.lakshmi.authentication_servcie.service.Interface.IJwtTokenService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CifVerificationService implements ICifVerificationService {

    private final LoginAttemptRepository loginAttemptRepository;
    private final ClientRepository clientRepository;
    private final IJwtTokenService jwtTokenService;

    private final AuthSessionRepository authSessionRepository;

    public CifVerificationService(LoginAttemptRepository loginAttemptRepository, ClientRepository clientRepository, IJwtTokenService jwtTokenService, AuthSessionRepository authSessionRepository) {
        this.loginAttemptRepository = loginAttemptRepository;
        this.clientRepository = clientRepository;
        this.jwtTokenService = jwtTokenService;
        this.authSessionRepository = authSessionRepository;
    }

    @Override
    public CifVerificationResponse verify(CifVerificationRequest request, String ipAddress) {

        LoginAttempt attempt = new LoginAttempt();
        attempt.setCif(request.getCifNumber());
        attempt.setCatchPhrase(request.getCatchPhrase());
        attempt.setImei(request.getImei());
        attempt.setDeviceModel(request.getDeviceModel());
        attempt.setMobileNumber(request.getMobileNumber());
        attempt.setTimestamp(LocalDateTime.now());

        Client client = clientRepository.findByCifNumber(request.getCifNumber()).orElseThrow(() -> new ClientNotFoundException("CIF number not found. Please check with the bank."));

        if (!client.getCatchPhrase().equals(request.getCatchPhrase())) {
            long failedCount = loginAttemptRepository.countByCifAndStatus(request.getCifNumber(), "FAILED");
            int attemptsLeft = 2 - (int) failedCount;

            attempt.setStatus("FAILED");
            attempt.setAttemptCount((int) failedCount + 1);
            loginAttemptRepository.save(attempt);

            if (attemptsLeft <= 0) {
                throw new LoginAttemptLimitExceededException("Too many invalid attempts. Please contact the bank.");
            }

            throw new InvalidCatchPhraseException("Invalid catchphrase. " + attemptsLeft + " attempts remaining.");
        }

        // ✅ Success Case
        attempt.setStatus("SUCCESS");
        attempt.setIpAddress(ipAddress);
        loginAttemptRepository.save(attempt);

        String token = jwtTokenService.generateToken(request.getCifNumber());

        AuthSession session = new AuthSession();
        session.setCifNumber(request.getCifNumber());
        session.setJwtToken(token);
        session.setActive(true);
        session.setIpAddress(ipAddress);
        authSessionRepository.save(session);


        CifVerificationResponse response = new CifVerificationResponse();
        response.setCifNumber(client.getCifNumber());
        response.setJwt(token);
        response.setClientName(client.getClientName());
        response.setClientCode(client.getClientCode());
        response.setJwt(token);
        response.setMessage("Welcome! Please register your mobile.");
        response.setStatus("SUCCESS");
        return response;
    }
}
