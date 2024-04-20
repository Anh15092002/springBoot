package com.webSales.mapper;

import com.webSales.dto.DeliveryDto;
import com.webSales.entity.Delivery;

public class DeliveryMapper {
    public static DeliveryDto mapToDeliveryDto(Delivery delivery) {
        return new DeliveryDto(
                delivery.getId(),
                delivery.getMethod(),
                delivery.getDelivery_time()
        );
    }

    public static Delivery mapToDelivery(DeliveryDto deliveryDto) {
        return new Delivery(
                deliveryDto.getId(),
                deliveryDto.getMethod(),
                deliveryDto.getDelivery_time()
        );
    }
}
