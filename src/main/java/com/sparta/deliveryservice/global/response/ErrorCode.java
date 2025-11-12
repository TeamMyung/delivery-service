package com.sparta.deliveryservice.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // delivery
    DELIVERY_NOT_FOUND(6001, HttpStatus.NOT_FOUND, "일치하는 주문을 찾을 수 없습니다."),

    ;

    private final int code;
    private final HttpStatus status;
    private final String details;
}
