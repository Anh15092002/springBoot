package com.webSales.mapper;

import com.webSales.dto.OrderDetailDto;
import com.webSales.entity.Good;
import com.webSales.entity.OrderDetail;
import com.webSales.entity.Orderr;

public class OrderDetailMapper {
    public static OrderDetailDto mapToOrderDetailDto(OrderDetail orderDetail) {
        return new OrderDetailDto(
              orderDetail.getId(),
              orderDetail.getOrder_id().getId(),
              orderDetail.getGood_id().getId(),
              orderDetail.getQuantity(),
              orderDetail.getPrice(),
              orderDetail.getDiscount()
        );
    }

    public static OrderDetail mapToOrderDetail(OrderDetailDto orderDetailDto) {
        if (orderDetailDto == null) {
            return null;
        }
        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setId(orderDetailDto.getId());
        if (orderDetailDto.getOrder_id() != null) {
            Orderr orderr = new Orderr();
            orderr.setId(orderDetailDto.getOrder_id());
            orderDetail.setOrder_id(orderr);
        }
        if (orderDetailDto.getGood_id() != null) {
            Good good = new Good();
            good.setId(orderDetailDto.getGood_id());
            orderDetail.setGood_id(good);
        }
        orderDetail.setQuantity(orderDetailDto.getQuantity());
        orderDetail.setPrice(orderDetailDto.getPrice());
        orderDetail.setDiscount(orderDetailDto.getDiscount());
        return orderDetail;
    };
}
