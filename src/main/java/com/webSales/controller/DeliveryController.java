package com.webSales.controller;


import com.webSales.dto.DeliveryDto;
import com.webSales.service.DeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {
    private DeliveryService deliveryService;

    //Build Add Delivery REST API
    @PostMapping
    public ResponseEntity<DeliveryDto> createDelivery(@RequestBody DeliveryDto deliveryDto) {
        DeliveryDto savedDelivery = deliveryService.createDelivery(deliveryDto);
        return new ResponseEntity<>(savedDelivery, HttpStatus.CREATED);
    }
    //Build Get Delivery REST API
    @GetMapping("{id}")
    public ResponseEntity<DeliveryDto> getDeliveryById(@PathVariable("id") Integer deliveryId) {
        DeliveryDto deliveryDto = deliveryService.getDeliveryById(deliveryId);
        return ResponseEntity.ok(deliveryDto);
    }

    //Build Get All Delivery REST API
    @GetMapping
    public ResponseEntity<List<DeliveryDto>> getAllDelivery() {
        List<DeliveryDto> deliverys = deliveryService.getAllDelivery();
        return ResponseEntity.ok(deliverys);
    }

    //Build Update Delivery REST API
    @PutMapping("{id}")
    public ResponseEntity<DeliveryDto> updateDelivery(@PathVariable("id") Integer deliveryId,
                                                      @RequestBody DeliveryDto updateDelivery){
        DeliveryDto deliveryDto = deliveryService.updateDelivery(deliveryId, updateDelivery);
        return ResponseEntity.ok(deliveryDto);
    }

    //Build Delete Delivery REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDelivery(@PathVariable("id") Integer deliveryId) {
        deliveryService.deleteDelivery(deliveryId);
        return ResponseEntity.ok("Delivery deleted successfully!.");
    }
}
