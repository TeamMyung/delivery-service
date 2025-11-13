package com.sparta.deliveryservice.dto.deliverypath;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateDeliveryPathResDto {

    private UUID deliveryPathId;
    private UUID deliveryId;
    private int sequence;
    private String status;
    private UUID startHubId;
    private UUID endHubId;
    private int estimated_distance;
    private int estimated_time;
    private int actual_distance;
    private int actual_time;
    private Long hubDeliveryUserId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}