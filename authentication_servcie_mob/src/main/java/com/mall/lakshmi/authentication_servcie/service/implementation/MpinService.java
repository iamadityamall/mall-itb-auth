package com.mall.lakshmi.authentication_servcie.service.implementation;

import com.mall.lakshmi.authentication_servcie.dto.ChangeMpinRequest;
import com.mall.lakshmi.authentication_servcie.dto.CreateMpinRequest;
import com.mall.lakshmi.authentication_servcie.dto.ForgotMpinRequest;
import com.mall.lakshmi.authentication_servcie.entity.UserMpin;
import com.mall.lakshmi.authentication_servcie.exception.custom.mpin.InvalidMpinException;
import com.mall.lakshmi.authentication_servcie.exception.custom.mpin.MpinNotFoundException;
import com.mall.lakshmi.authentication_servcie.repository.MpinRepository;
import com.mall.lakshmi.authentication_servcie.service.Interface.IMpinService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class MpinService implements IMpinService {

    private final MpinRepository repository;

    public MpinService(MpinRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createMpin(CreateMpinRequest request) {
        String hashed = BCrypt.hashpw(request.getMpin(), BCrypt.gensalt());
        UserMpin mpin = new UserMpin();
        mpin.setCifNumber(request.getCifNumber());
        mpin.setHashedMpin(hashed);
        repository.save(mpin);
    }

    @Override
    public void changeMpin(ChangeMpinRequest request) {
        UserMpin userMpin  = repository.findByCifNumber(request.getCifNumber())
                .orElseThrow(() -> new MpinNotFoundException("MPIN not set for this user."));

        if(!BCrypt.checkpw(request.getOldMpin(), userMpin.getHashedMpin())){
            throw  new InvalidMpinException("Old MPIN does not match.");
        }

        userMpin.setHashedMpin(BCrypt.hashpw(request.getNewMpin(), BCrypt.gensalt()));
        repository.save(userMpin);
    }

    @Override
    public void resetMpin(ForgotMpinRequest request) {
        UserMpin userMpin = repository.findByCifNumber(request.getCifNumber())
                .orElseThrow(() -> new MpinNotFoundException("MPIN not set for this user."));
        userMpin.setHashedMpin(BCrypt.hashpw(request.getNewMpin(), BCrypt.gensalt()));
        repository.save(userMpin);
    }
}
