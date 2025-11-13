package com.sparta.deliveryservice.client;

import com.sparta.deliveryservice.dto.deliverypath.CreateDeliveryPathReqDto;
import com.sparta.deliveryservice.dto.deliverypath.CreateDeliveryPathResDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "delivery-path-service", url = "http://localhost:8080")

public interface DeliveryPathClient {

    @PostMapping("/delivery-paths")
    CreateDeliveryPathResDto createDeliveryPath(@RequestBody CreateDeliveryPathReqDto req);
}
