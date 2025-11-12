package com.sparta.deliveryservice.service;

import com.sparta.deliveryservice.domain.Delivery;
import com.sparta.deliveryservice.dto.request.CreateDeliveryReqDto;
import com.sparta.deliveryservice.dto.response.CreateDeliveryResDto;
import com.sparta.deliveryservice.dto.response.GetDeliveryResDto;
import com.sparta.deliveryservice.global.exception.DeliveryException;
import com.sparta.deliveryservice.global.response.ErrorCode;
import com.sparta.deliveryservice.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.sparta.deliveryservice.domain.DeliveryStatus.HUB_PENDING;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public CreateDeliveryResDto createDelivery(CreateDeliveryReqDto requestDto) {
        return CreateDeliveryResDto.from(deliveryRepository.save(
                        Delivery.builder()
                                .deliveryId(UUID.randomUUID())
                                .orderId(requestDto.getOrderId())
                                .status(HUB_PENDING)
                                .startHubId(requestDto.getStartHubId())
                                .endHubId(requestDto.getEndHubId())
                                .address(requestDto.getAddress())
                                .slackAccoutId(requestDto.getSlackAccountId())
                                .vendorDeliveryUserId(requestDto.getVendorDeliveryUserId())
                                .build()
                )
        );
    }

    public GetDeliveryResDto getDelivery(UUID deliveryId) {
        return GetDeliveryResDto.from(deliveryRepository.findByDeliveryId(deliveryId)
                .orElseThrow(() -> {
                    log.error("주문을 찾을 수 없음: deliveryId={}", deliveryId);
                    return new DeliveryException(ErrorCode.DELIVERY_NOT_FOUND);
                })
        );
    }
}
