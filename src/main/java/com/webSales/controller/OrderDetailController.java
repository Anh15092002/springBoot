package com.webSales.controller;

import com.webSales.dto.OrderDetailDto;
import com.webSales.service.OrderDetailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/orderDetail")
public class OrderDetailController {
    private OrderDetailService orderDetailService;

    @PostMapping
    public ResponseEntity<OrderDetailDto> createOrderDetail(@RequestBody OrderDetailDto orderDetailDto) {
        OrderDetailDto savedOrderDetail = orderDetailService.createOrderDetail(orderDetailDto);
        return new ResponseEntity<>(savedOrderDetail, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<OrderDetailDto> getOrderDetailById(@PathVariable("id") Integer orderDetailId) {
        OrderDetailDto orderDetailDto = orderDetailService.getOrderDetailById(orderDetailId);
        return ResponseEntity.ok(orderDetailDto);
    }

    @GetMapping
    public ResponseEntity<List<OrderDetailDto>>getAllOrderDetail() {
        List<OrderDetailDto> orderDetails = orderDetailService.getAllOrderDetails();
        return ResponseEntity.ok(orderDetails);
    }

    @PutMapping("{id}")
    public ResponseEntity<OrderDetailDto> updateOrderDetail(@PathVariable("id") Integer orderDetailId,
                                                            @RequestBody OrderDetailDto updateOrderDetail) {
        OrderDetailDto orderDetailDto = orderDetailService.updateOrderDetail(orderDetailId, updateOrderDetail);
        return ResponseEntity.ok(orderDetailDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrderDetail(@PathVariable("id") Integer orderDetailId) {
        orderDetailService.deleteOrderDetail(orderDetailId);
        return ResponseEntity.ok("OrderDetail deleted successfully!.");
    }
}
