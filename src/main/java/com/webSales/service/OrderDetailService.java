package com.webSales.service;

import com.webSales.dto.OrderDetailDto;

import java.util.List;

public interface OrderDetailService {

    OrderDetailDto createOrderDetail(OrderDetailDto orderDetailDto);

    OrderDetailDto getOrderDetailById(Integer orderDetailId);

    List<OrderDetailDto> getAllOrderDetails();

    OrderDetailDto updateOrderDetail(Integer orderDetailId, OrderDetailDto updateOrderDetail);

    void deleteOrderDetail(Integer orderDetailId);
}
