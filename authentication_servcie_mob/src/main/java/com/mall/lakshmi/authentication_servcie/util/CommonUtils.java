package com.mall.lakshmi.authentication_servcie.util;

import jakarta.servlet.http.HttpServletRequest;

public class CommonUtils {
    public static String getClientIp(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        } else {
            // Handle multiple IPs in X-Forwarded-For header
            ipAddress = ipAddress.split(",")[0];
        }
        return ipAddress;
    }

}
