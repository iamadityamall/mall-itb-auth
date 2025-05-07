//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mall.lakshmi.authentication_service.exception;

import com.mall.lakshmi.authentication_service.dto.ApiResponse;
import com.mall.lakshmi.authentication_service.exception.customExceptions.CifNotFoundException;
import com.mall.lakshmi.authentication_service.exception.customExceptions.DeviceAlreadyRegisteredException;
import com.mall.lakshmi.authentication_service.exception.customExceptions.MpinMismatchException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    public GlobalExceptionHandler() {
    }

    @ExceptionHandler({MpinMismatchException.class})
    public ResponseEntity<ApiResponse<Object>> handleCifNotFound(MpinMismatchException exception) {
        ApiResponse<Object> response = new ApiResponse("FAILURE", exception.getMessage(), (Object)null, LocalDateTime.now());
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({DeviceAlreadyRegisteredException.class})
    public ResponseEntity<ApiResponse<Object>> handleCifNotFound(DeviceAlreadyRegisteredException exception) {
        ApiResponse<Object> response = new ApiResponse("FAILURE", exception.getMessage(), (Object)null, LocalDateTime.now());
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({CifNotFoundException.class})
    public ResponseEntity<ApiResponse<Object>> handleCifNotFound(CifNotFoundException exception) {
        ApiResponse<Object> response = new ApiResponse("FAILURE", exception.getMessage(), (Object)null, LocalDateTime.now());
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ApiResponse<Object>> handleValidationExceptions(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap();
        exception.getBindingResult().getFieldErrors().forEach((error) -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        ApiResponse<Object> response = new ApiResponse("Failure", "Validation Failed", errors, LocalDateTime.now());
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiResponse<Object>> handleGenericException(Exception exception) {
        ApiResponse<Object> response = new ApiResponse("Failure", exception.getMessage(), (Object)null, LocalDateTime.now());
        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
