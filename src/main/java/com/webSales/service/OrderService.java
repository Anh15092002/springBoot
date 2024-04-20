package com.webSales.service;

import com.webSales.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);
    OrderDto getOrderById(Integer orderId);
    List<OrderDto> getAllOrder();
    OrderDto updateOrder(Integer orderId, OrderDto updateOrder);
    void deleteOrder(Integer orderId);
}
