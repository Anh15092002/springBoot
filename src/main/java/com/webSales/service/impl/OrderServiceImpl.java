package com.webSales.service.impl;

import com.webSales.dto.OrderDto;
import com.webSales.entity.Member;
import com.webSales.entity.Orderr;
import com.webSales.exception.ResourceNotFoundException;
import com.webSales.mapper.OrderMapper;
import com.webSales.repository.MemberRepository;
import com.webSales.repository.OrderrRespository;
import com.webSales.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private OrderrRespository orderrRespository;
    private MemberRepository memberRepository;

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Orderr orderr = OrderMapper.mapToOrder(orderDto);
        Orderr saveOrder = orderrRespository.save(orderr);
        return OrderMapper.mapToOrderDto(saveOrder);
    }

    @Override
    public OrderDto getOrderById(Integer orderId) {
        Orderr orderr = orderrRespository.findById(orderId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Order is not exist with given id: " + orderId));
        return OrderMapper.mapToOrderDto(orderr);
    }

    @Override
    public List<OrderDto> getAllOrder() {

        List<Orderr> orderrs = orderrRespository.findAll();
        return orderrs.stream().map((orderr) -> OrderMapper.mapToOrderDto(orderr))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto updateOrder(Integer orderId, OrderDto updateOrder) {
        Orderr orderr = orderrRespository.findById(orderId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Order is not exist with given id: " + orderId));
        if (updateOrder.getMember_id() != null) {
            Member member = memberRepository.findById(updateOrder.getMember_id())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Member is not exist given id: " + updateOrder.getMember_id()));
            orderr.setMember_id(member);
        }
        orderr.setOrderDate(updateOrder.getOrderDate());
        orderr.setTotalAmount(updateOrder.getTotalAmount());
        orderr.setStatus(updateOrder.getStatus());
        orderr.setShippingAddress(updateOrder.getShippingAddress());
        orderr.setShippingMethod(updateOrder.getShippingMethod());
        Orderr updateOrderObj = orderrRespository.save(orderr);
        return OrderMapper.mapToOrderDto(updateOrderObj);
    }

    @Override
    public void deleteOrder(Integer orderId) {
        Orderr orderr = orderrRespository.findById(orderId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Order is not exist with given id: " + orderId));
        orderrRespository.deleteById(orderId);
    }
}
