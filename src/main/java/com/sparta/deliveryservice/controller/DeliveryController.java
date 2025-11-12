package com.sparta.deliveryservice.controller;

import com.sparta.deliveryservice.dto.request.CreateDeliveryReqDto;
import com.sparta.deliveryservice.dto.request.UpdateDeliveryStatusReqDto;
import com.sparta.deliveryservice.dto.response.CreateDeliveryResDto;
import com.sparta.deliveryservice.dto.response.GetDeliveryResDto;
import com.sparta.deliveryservice.dto.response.UpdateDeliveryStatusResDto;
import com.sparta.deliveryservice.global.response.ApiResponse;
import com.sparta.deliveryservice.service.DeliveryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/deliveries")
public class DeliveryController {

    private final DeliveryService deliveryService;

    /**
     * 배송 정보 생성 (Order -> Delivery 호출)
     */
    @PostMapping
    public ApiResponse<CreateDeliveryResDto> createDelivery(@Valid @RequestBody CreateDeliveryReqDto requestDto) {
        return new ApiResponse<>(deliveryService.createDelivery(requestDto));
    }

    /**
     * 단일 배송 정보 조회
     */
    @GetMapping("/{deliveryId}")
    public ApiResponse<GetDeliveryResDto> getDelivery(@PathVariable UUID deliveryId) {
        return new ApiResponse<>(deliveryService.getDelivery(deliveryId));
    }

    /**
     * 주문 상태 변경
     */
    @PatchMapping("/{deliveryId}/status")
    public ApiResponse<UpdateDeliveryStatusResDto> updateDeliveryStatus(
            @PathVariable UUID deliveryId, UpdateDeliveryStatusReqDto requestDto
    ) {
        return new ApiResponse<>(deliveryService.updateDeliveryStatus(deliveryId, requestDto));
    }
}
