package com.sparta.deliveryservice.dto.response;

import com.sparta.deliveryservice.domain.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDeliveryStatusResDto {

    private DeliveryStatus deliveryStatus;
}
