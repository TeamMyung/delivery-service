package com.sparta.deliveryservice.dto.request;

import com.sparta.deliveryservice.domain.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDeliveryStatusReqDto {

    private DeliveryStatus deliveryStatus;
}
