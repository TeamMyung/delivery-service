package com.sparta.deliveryservice.domain;

public enum DeliveryStatus {
    HUB_PENDING,          // 허브 대기중
    HUB_IN_TRANSIT,       // 허브 이동중
    DEST_HUB_ARRIVED,     // 목적지 허브 도착
    OUT_FOR_DELIVERY,     // 배송중
    TO_VENDOR_IN_TRANSIT, // 업체이동중
    COMPLETED             // 배송완료
}