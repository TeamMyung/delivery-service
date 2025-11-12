package com.sparta.deliveryservice.controller;

import com.sparta.deliveryservice.dto.request.CreateDeliveryReqDto;
import com.sparta.deliveryservice.dto.response.CreateDeliveryResDto;
import com.sparta.deliveryservice.service.DeliveryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/deliveries")
public class DeliveryController {

    private final DeliveryService deliveryService;

    @PostMapping
    public ResponseEntity<CreateDeliveryResDto> createDelivery(@Valid @RequestBody CreateDeliveryReqDto requestDto) {
        return ResponseEntity.ok(deliveryService.createDelivery(requestDto));
    }
}
