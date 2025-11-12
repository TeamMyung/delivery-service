package com.sparta.deliveryservice.global.exception;

import com.sparta.deliveryservice.global.response.ErrorCode;

public class DeliveryException extends RuntimeException {
    private final ErrorCode errorCode;

    public DeliveryException(ErrorCode errorCode) {
        super(errorCode.getDetails());
        this.errorCode = errorCode;
    }
}
