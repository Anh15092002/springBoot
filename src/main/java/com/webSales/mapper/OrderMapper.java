package com.webSales.mapper;

import com.webSales.dto.OrderDto;
import com.webSales.entity.Member;
import com.webSales.entity.Orderr;


public class OrderMapper {
    public static OrderDto mapToOrderDto(Orderr orderr) {
        return new OrderDto(
                orderr.getId(),
                orderr.getMember_id().getId(),
                orderr.getOrderDate(),
                orderr.getTotalAmount(),
                orderr.getStatus(),
                orderr.getShippingAddress(),
                orderr.getShippingMethod()
        );
    }

    public static Orderr mapToOrder(OrderDto orderDto) {
        if (orderDto == null) {
            return null;
        }

        Orderr orderr = new Orderr();
        orderr.setId(orderDto.getId());
        if (orderDto.getMember_id() != null) {
            Member member = new Member();
            member.setId(orderDto.getMember_id());
            orderr.setMember_id(member);
        }
        orderr.setOrderDate(orderDto.getOrderDate());
        orderr.setTotalAmount(orderDto.getTotalAmount());
        orderr.setStatus(orderDto.getStatus());
        orderr.setShippingAddress(orderDto.getShippingAddress());
        orderr.setShippingMethod(orderDto.getShippingMethod());
        return orderr;
    };
}
