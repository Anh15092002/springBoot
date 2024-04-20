package com.webSales.service;

import com.webSales.dto.DeliveryDto;

import java.util.List;

public interface DeliveryService {
    DeliveryDto createDelivery(DeliveryDto deliveryDto);

    DeliveryDto getDeliveryById(Integer deliveryId);

    List<DeliveryDto> getAllDelivery();

    DeliveryDto updateDelivery(Integer deliveryId, DeliveryDto updateDelivery);

    void deleteDelivery(Integer deliveryId);
}
