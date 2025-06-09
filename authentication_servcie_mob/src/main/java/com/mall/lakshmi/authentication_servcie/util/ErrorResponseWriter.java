package com.mall.lakshmi.authentication_servcie.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ErrorResponseWriter {
    private static final ObjectMapper mapper = new ObjectMapper();


    public static void write(HttpServletResponse response, int httpStatus, String errorCode, String message) throws IOException {
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        Map<String, Object> payload = new HashMap<>();
        payload.put("code", httpStatus);
        payload.put("error", errorCode);
        payload.put("message", message);

        Map<String, Object> fullResponse = new HashMap<>();
        fullResponse.put("status", "FAILED");
        fullResponse.put("message", message);
        fullResponse.put("payload", payload);
        fullResponse.put("timeStamp", LocalDateTime.now());

        response.setStatus(httpStatus);
        response.setContentType("application/json");
        mapper.writeValue(response.getWriter(), fullResponse);
    }
}
