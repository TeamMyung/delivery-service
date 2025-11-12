package com.sparta.deliveryservice.dto.deliverypath;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateDeliveryPathReqDto {
    private UUID deliveryId;
    private UUID firstHubId;
    private UUID finalHubId;
}