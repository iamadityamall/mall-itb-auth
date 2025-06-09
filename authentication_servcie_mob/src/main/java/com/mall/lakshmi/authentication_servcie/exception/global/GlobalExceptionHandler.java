package com.mall.lakshmi.authentication_servcie.exception.global;

import com.mall.lakshmi.authentication_servcie.dto.ApiResponse;
import com.mall.lakshmi.authentication_servcie.dto.ErrorResponse;
import com.mall.lakshmi.authentication_servcie.exception.custom.auth.InvalidSessionException;
import com.mall.lakshmi.authentication_servcie.exception.custom.cif.ClientNotFoundException;
import com.mall.lakshmi.authentication_servcie.exception.custom.cif.InvalidCatchPhraseException;
import com.mall.lakshmi.authentication_servcie.exception.custom.cif.LoginAttemptLimitExceededException;
import com.mall.lakshmi.authentication_servcie.exception.custom.mpin.InvalidMpinException;
import com.mall.lakshmi.authentication_servcie.exception.custom.mpin.MpinAlreadySetException;
import com.mall.lakshmi.authentication_servcie.exception.custom.mpin.MpinNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ApiResponse<ErrorResponse>> handleClientNotFound(ClientNotFoundException exception) {
        ErrorResponse error = new ErrorResponse(404, "CIF_NOT_FOUND", exception.getMessage());
        ApiResponse<ErrorResponse> response = new ApiResponse<>("FAILED", exception.getMessage(), error, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(InvalidCatchPhraseException.class)
    public ResponseEntity<ApiResponse<ErrorResponse>> handleInvalidCatchPhrase(InvalidCatchPhraseException exception) {
        ErrorResponse error = new ErrorResponse(400, "INVALID_CATCH_PHRASE", exception.getMessage());
        ApiResponse<ErrorResponse> response = new ApiResponse<>("FAILED", exception.getMessage(), error, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }


    @ExceptionHandler(LoginAttemptLimitExceededException.class)
    public ResponseEntity<ApiResponse<ErrorResponse>> handleLoginAttemptsExceeded(LoginAttemptLimitExceededException exception) {
        ErrorResponse error = new ErrorResponse(403, "ATTEMPT_LIMIT_EXCEEDED", exception.getMessage());
        ApiResponse<ErrorResponse> response = new ApiResponse<>("FAILED", exception.getMessage(), error, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

    @ExceptionHandler(MpinAlreadySetException.class)
    public ResponseEntity<ApiResponse<ErrorResponse>> handleMpinAlreadySet(MpinAlreadySetException ex) {
        ErrorResponse error = new ErrorResponse(409, "MPIN_ALREADY_EXISTS", ex.getMessage());
        ApiResponse<ErrorResponse> response = new ApiResponse<>("FAILED", ex.getMessage(), error, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(MpinNotFoundException.class)
    public ResponseEntity<ApiResponse<ErrorResponse>> handleMpinNotFound(MpinNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(404, "MPIN_NOT_FOUND", ex.getMessage());
        ApiResponse<ErrorResponse> response = new ApiResponse<>("FAILED", ex.getMessage(), error, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(InvalidMpinException.class)
    public ResponseEntity<ApiResponse<ErrorResponse>> handleInvalidMpin(InvalidMpinException ex) {
        ErrorResponse error = new ErrorResponse(400, "INVALID_MPIN", ex.getMessage());
        ApiResponse<ErrorResponse> response = new ApiResponse<>("FAILED", ex.getMessage(), error, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(InvalidSessionException.class)
    public ResponseEntity<ApiResponse<ErrorResponse>> handleInvalidSession(InvalidSessionException ex) {
        ErrorResponse error = new ErrorResponse(401, "INVALID_SESSION", ex.getMessage());
        ApiResponse<ErrorResponse> response = new ApiResponse<>("FAILED", ex.getMessage(), error, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }




    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<ErrorResponse>> handleGeneric(Exception exception) {
        exception.printStackTrace();
        ErrorResponse error = new ErrorResponse(500, "INTERNAL_ERROR", "Something went wrong.");
        ApiResponse<ErrorResponse> response = new ApiResponse<>("FAILED", "Something went wrong.", error, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

}
