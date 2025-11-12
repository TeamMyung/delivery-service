package com.sparta.deliveryservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateDeliveryReqDto {

    @NotNull
    private UUID orderId;

    @NotNull
    private UUID startHubId;

    @NotNull
    private UUID endHubId;

    @NotBlank
    private String address;

    @NotBlank
    private String slackAccountId;

    @NotNull
    private Long vendorDeliveryUserId;
}
