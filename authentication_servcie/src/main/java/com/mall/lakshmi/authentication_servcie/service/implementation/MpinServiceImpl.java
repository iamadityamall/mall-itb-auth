//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_servcie.service.implementation;


import com.mall.lakshmi.authentication_servcie.dto.MpinRequest;
import com.mall.lakshmi.authentication_servcie.dto.MpinResponse;
import com.mall.lakshmi.authentication_servcie.entity.CustomerMpin;
import com.mall.lakshmi.authentication_servcie.entity.CustomerMpinHistory;
import com.mall.lakshmi.authentication_servcie.repository.CustomerMpinHistoryRepository;
import com.mall.lakshmi.authentication_servcie.repository.CustomerMpinRepository;
import com.mall.lakshmi.authentication_servcie.service.Interface.MpinServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MpinServiceImpl implements MpinServiceInterface {
    private final CustomerMpinRepository customerMpinRepository;
    private final CustomerMpinHistoryRepository customerMpinHistoryRepository;

    public MpinServiceImpl(CustomerMpinRepository customerMpinRepository, CustomerMpinHistoryRepository customerMpinHistoryRepository) {
        this.customerMpinRepository = customerMpinRepository;
        this.customerMpinHistoryRepository = customerMpinHistoryRepository;
    }

    public MpinResponse registerMpin(MpinRequest mpinRequest) {
        CustomerMpin newMpin = new CustomerMpin(mpinRequest.getCifNumber(), mpinRequest.getMpin());
        this.customerMpinRepository.save(newMpin);
        this.customerMpinHistoryRepository.save(new CustomerMpinHistory(mpinRequest.getCifNumber(), mpinRequest.getMpin(), true));
        return new MpinResponse(mpinRequest.getCifNumber(), "MPIN registered and history updated.");
    }

    public void updateMpin(MpinRequest mpinRequest) {
        Optional<CustomerMpin> mpin = this.customerMpinRepository.findByCifNumber(mpinRequest.getCifNumber());
        ((CustomerMpin)mpin.get()).setMpin(mpinRequest.getMpin());
        this.customerMpinRepository.save((CustomerMpin)mpin.get());
        List<CustomerMpinHistory> oldRecords = this.customerMpinHistoryRepository.findByCifNumber(mpinRequest.getCifNumber());
        oldRecords.forEach((record) -> {
            record.setActive(false);
        });
        this.customerMpinHistoryRepository.saveAll(oldRecords);
        CustomerMpinHistory history = new CustomerMpinHistory(mpinRequest.getCifNumber(), mpinRequest.getMpin(), true);
        this.customerMpinHistoryRepository.save(history);
    }
}
