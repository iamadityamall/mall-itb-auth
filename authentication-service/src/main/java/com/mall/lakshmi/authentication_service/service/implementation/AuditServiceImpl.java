//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_service.service.implementation;

import com.mall.lakshmi.authentication_service.entity.AuditLog;
import com.mall.lakshmi.authentication_service.repository.AuditLogRepository;
import com.mall.lakshmi.authentication_service.service.Interface.AuditServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class AuditServiceImpl implements AuditServiceInterface {
    private final AuditLogRepository auditLogRepository;

    public AuditServiceImpl(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    public void log(String cifNumber, String imei, String action, String status) {
        AuditLog log = new AuditLog(cifNumber, imei, action, status);
        this.auditLogRepository.save(log);
    }
}
