package com.sparta.deliveryservice.service;

import com.sparta.deliveryservice.client.DeliveryPathClient;
import com.sparta.deliveryservice.domain.Delivery;
import com.sparta.deliveryservice.dto.deliverypath.CreateDeliveryPathReqDto;
import com.sparta.deliveryservice.dto.deliverypath.CreateDeliveryPathResDto;
import com.sparta.deliveryservice.dto.request.CreateDeliveryReqDto;
import com.sparta.deliveryservice.dto.request.UpdateDeliveryStatusReqDto;
import com.sparta.deliveryservice.dto.response.CreateDeliveryResDto;
import com.sparta.deliveryservice.dto.response.GetDeliveryResDto;
import com.sparta.deliveryservice.dto.response.UpdateDeliveryStatusResDto;
import com.sparta.deliveryservice.global.exception.DeliveryException;
import com.sparta.deliveryservice.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static com.sparta.deliveryservice.domain.DeliveryStatus.HUB_PENDING;
import static com.sparta.deliveryservice.global.response.ErrorCode.DELIVERY_NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final DeliveryPathClient deliveryPathClient;

    /**
     * 배송 정보 생성
     */
    @Transactional
    public CreateDeliveryResDto createDelivery(CreateDeliveryReqDto requestDto) {
        Delivery delivery = deliveryRepository.save(
                Delivery.builder()
                        .deliveryId(UUID.randomUUID())
                        .orderId(requestDto.getOrderId())
                        .deliveryStatus(HUB_PENDING)
                        .startHubId(requestDto.getStartHubId())
                        .endHubId(requestDto.getEndHubId())
                        .address(requestDto.getAddress())
                        .slackAccoutId(requestDto.getSlackAccountId())
                        .vendorDeliveryUserId(requestDto.getVendorDeliveryUserId())
                        .build()
        );

        try {
            CreateDeliveryPathResDto deliveryPath = deliveryPathClient.createDeliveryPath(CreateDeliveryPathReqDto.builder()
                    .deliveryId(delivery.getDeliveryId())
                    .firstHubId(delivery.getStartHubId())
                    .finalHubId(delivery.getEndHubId())
                    .build());

            log.info("경로 생성 완료: deliveryPathId={}", deliveryPath.getDeliveryPathId());
        } catch (Exception e) {
            log.error("경로 생성 실패: deliveryId={} - {}", delivery.getDeliveryId(), e.getMessage());
        }

        return CreateDeliveryResDto.from(delivery);
    }

    /**
     * 배송 정보 단일 조회
     */
    public GetDeliveryResDto getDelivery(UUID deliveryId) {
        return GetDeliveryResDto.from(deliveryRepository.findByDeliveryId(deliveryId)
                .orElseThrow(() -> {
                    log.error("주문을 찾을 수 없음: deliveryId={}", deliveryId);
                    return new DeliveryException(DELIVERY_NOT_FOUND);
                })
        );
    }

    /**
     * 배송 상태 수정
     */
    @Transactional
    public UpdateDeliveryStatusResDto updateDeliveryStatus(UUID deliveryId, UpdateDeliveryStatusReqDto requestDto) {
        Delivery delivery = findDeliveryById(deliveryId);
        delivery.updateDeliveryStatus(requestDto.getDeliveryStatus());

        return new UpdateDeliveryStatusResDto(delivery.getDeliveryStatus());
    }

    // ========================== 유틸 메서드 ==========================

    private Delivery findDeliveryById(UUID deliveryId) {
        return deliveryRepository.findByDeliveryId(deliveryId)
                .orElseThrow(() -> {
                    log.error("배송 정보를 찾을 수 없음: deliveryId={}", deliveryId);
                    return new DeliveryException(DELIVERY_NOT_FOUND);
                });
    }
}
