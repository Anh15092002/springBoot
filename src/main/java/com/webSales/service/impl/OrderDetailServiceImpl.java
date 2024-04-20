package com.webSales.service.impl;

import com.webSales.dto.OrderDetailDto;
import com.webSales.entity.Good;
import com.webSales.entity.OrderDetail;
import com.webSales.entity.Orderr;
import com.webSales.exception.ResourceNotFoundException;
import com.webSales.mapper.OrderDetailMapper;
import com.webSales.repository.GoodRespository;
import com.webSales.repository.OrderDetailRespository;
import com.webSales.repository.OrderrRespository;
import com.webSales.service.OrderDetailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {
    private OrderDetailRespository orderDetailRespository;
    private OrderrRespository orderrRespository;
    private GoodRespository goodRespository;

    @Override
    public OrderDetailDto createOrderDetail(OrderDetailDto orderDetailDto) {
        OrderDetail orderDetail = OrderDetailMapper.mapToOrderDetail(orderDetailDto);
        OrderDetail savedOrderDetail = orderDetailRespository.save(orderDetail);
        return OrderDetailMapper.mapToOrderDetailDto(savedOrderDetail);
    }

    @Override
    public OrderDetailDto getOrderDetailById(Integer orderDetailId) {
        OrderDetail orderDetail = orderDetailRespository.findById(orderDetailId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("OrderDetail is not exist with given id: " + orderDetailId));

        return OrderDetailMapper.mapToOrderDetailDto(orderDetail);
    }

    @Override
    public List<OrderDetailDto> getAllOrderDetails() {
        List<OrderDetail> orderDetails = orderDetailRespository.findAll();
        return orderDetails.stream().map((orderDetail) -> OrderDetailMapper.mapToOrderDetailDto(orderDetail))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDetailDto updateOrderDetail(Integer orderDetailId, OrderDetailDto updateOrderDetail) {
        OrderDetail orderDetail = orderDetailRespository.findById(orderDetailId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("OrderDetail is not exist with given id: " + orderDetailId));
        if (updateOrderDetail.getOrder_id() != null) {
            Orderr orderr = orderrRespository.findById(updateOrderDetail.getOrder_id())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Order is not exist with given id: " + updateOrderDetail.getOrder_id()));
            orderDetail.setOrder_id(orderr);
        }
        if (updateOrderDetail.getGood_id() != null) {
            Good good = goodRespository.findById(updateOrderDetail.getGood_id())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Good is not exist with given id: " + updateOrderDetail.getGood_id()));
            orderDetail.setGood_id(good);
        }
        orderDetail.setQuantity(updateOrderDetail.getQuantity());
        orderDetail.setPrice(updateOrderDetail.getPrice());
        orderDetail.setDiscount(updateOrderDetail.getDiscount());

        OrderDetail updateOrderDetailObj = orderDetailRespository.save(orderDetail);
        return OrderDetailMapper.mapToOrderDetailDto(updateOrderDetailObj);
    }

    @Override
    public void deleteOrderDetail(Integer orderDetailId) {
        OrderDetail orderDetail = orderDetailRespository.findById(orderDetailId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("OrderDetail is not exist with given id: " + orderDetailId));
        orderDetailRespository.deleteById(orderDetailId);
    }
}
