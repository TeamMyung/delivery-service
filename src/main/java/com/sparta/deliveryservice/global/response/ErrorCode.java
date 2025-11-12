package com.sparta.deliveryservice.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // delivery
    DELIVERY_NOT_FOUND(6001, HttpStatus.NOT_FOUND, "일치하는 배송 정보를 찾을 수 없습니다."),

    DELIVERY_BAD_REQUEST(6497, HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    DELIVERY_CONFLICT(6498, HttpStatus.CONFLICT, "비즈니스 로직 수행 중 예외가 발생했습니다."),
    DELIVERY_INTERNAL_SERVER_ERROR(6499, HttpStatus.INTERNAL_SERVER_ERROR, "배송 서비스 수행 중 서버에 문제가 발생했습니다.");

    private final int code;
    private final HttpStatus status;
    private final String details;
}
