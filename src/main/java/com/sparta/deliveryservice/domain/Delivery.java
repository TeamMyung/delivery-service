package com.sparta.deliveryservice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "deliveries")
public class Delivery extends BaseEntity {

    @Id
    private UUID deliveryId;

    @Column(nullable = false)
    private UUID orderId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeliveryStatus status;

    @Column(nullable = false)
    private UUID startHubId;

    @Column(nullable = false)
    private UUID endHubId;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String slackAccoutId;

    @Column(nullable = false)
    private Long vendorDeliveryUserId;

    private UUID producerId;
    private UUID receiverId;
}
