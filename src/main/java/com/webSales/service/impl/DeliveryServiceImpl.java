package com.webSales.service.impl;

import com.webSales.dto.DeliveryDto;
import com.webSales.entity.Delivery;
import com.webSales.exception.ResourceNotFoundException;
import com.webSales.mapper.DeliveryMapper;
import com.webSales.repository.DeliveryRepository;
import com.webSales.service.DeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {
    private DeliveryRepository deliveryRepository;
    @Override
    public DeliveryDto createDelivery(DeliveryDto deliveryDto) {
        Delivery delivery = DeliveryMapper.mapToDelivery(deliveryDto);
        Delivery savedDelivery = deliveryRepository.save(delivery);

        return DeliveryMapper.mapToDeliveryDto(savedDelivery);
    }

    @Override
    public DeliveryDto getDeliveryById(Integer deliveryId) {
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Delivery is not exist with given id: " + deliveryId));

        return DeliveryMapper.mapToDeliveryDto(delivery);
    }

    @Override
    public List<DeliveryDto> getAllDelivery() {
        List<Delivery> deliveries = deliveryRepository.findAll();
        return deliveries.stream().map((delivery) -> DeliveryMapper.mapToDeliveryDto(delivery))
                .collect(Collectors.toList());
    }

    @Override
    public DeliveryDto updateDelivery(Integer deliveryId, DeliveryDto updateDelivery) {
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Delivery is not exist with given id: " + deliveryId));
        delivery.setMethod(updateDelivery.getMethod());
        delivery.setDelivery_time(updateDelivery.getDelivery_time());

        Delivery updateDeliveryObj = deliveryRepository.save(delivery);
        return DeliveryMapper.mapToDeliveryDto(updateDeliveryObj);
    }

    @Override
    public void deleteDelivery(Integer deliveryId) {
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Delivery is not exist with given id:" + deliveryId));
        deliveryRepository.deleteById(deliveryId);
    }
}
