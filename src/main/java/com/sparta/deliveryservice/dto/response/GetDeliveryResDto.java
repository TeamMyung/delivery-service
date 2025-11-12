package com.sparta.deliveryservice.dto.response;

import com.sparta.deliveryservice.domain.Delivery;
import com.sparta.deliveryservice.domain.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class GetDeliveryResDto {

    private UUID deliveryId;
    private UUID orderId;
    private DeliveryStatus status;
    private UUID startHubId;
    private UUID endHubId;
    private String address;
    private String slackAccoutId;
    private Long vendorDeliveryUserId;
    private UUID producerId;
    private UUID receiverId;

    public static GetDeliveryResDto from(Delivery delivery) {
        return GetDeliveryResDto.builder()
                .deliveryId(delivery.getDeliveryId())
                .orderId(delivery.getOrderId())
                .status(delivery.getStatus())
                .startHubId(delivery.getStartHubId())
                .endHubId(delivery.getEndHubId())
                .address(delivery.getAddress())
                .slackAccoutId(delivery.getSlackAccoutId())
                .vendorDeliveryUserId(delivery.getVendorDeliveryUserId())
                .producerId(delivery.getProducerId())
                .receiverId(delivery.getReceiverId())
                .build();
    }
}
