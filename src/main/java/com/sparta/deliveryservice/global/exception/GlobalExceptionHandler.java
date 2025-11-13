package com.sparta.deliveryservice.global.exception;

import com.sparta.deliveryservice.global.response.ApiResponse;
import com.sparta.deliveryservice.global.response.ErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.sparta.deliveryservice.global.response.ErrorCode.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DeliveryException.class)
    public ResponseEntity<ApiResponse> handleUserException(DeliveryException e) {
        ErrorCode errorCode = e.getErrorCode();
        return ResponseEntity
                .status(errorCode.getStatus())
                .body(new ApiResponse<>(errorCode));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<Void>> handleIllegalArgument(IllegalArgumentException e) {
        return ResponseEntity
                .badRequest()
                .body(new ApiResponse<>(DELIVERY_BAD_REQUEST));
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ApiResponse<Void>> handleIllegalState(IllegalStateException e) {
        return ResponseEntity
                .status(DELIVERY_CONFLICT.getStatus())
                .body(new ApiResponse<>(DELIVERY_CONFLICT));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleException(Exception e) {
        e.printStackTrace();
        return ResponseEntity
                .status(DELIVERY_INTERNAL_SERVER_ERROR.getStatus())
                .body(new ApiResponse<>(DELIVERY_INTERNAL_SERVER_ERROR));
    }
}