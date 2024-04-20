package com.webSales.repository;

import com.webSales.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRespository extends JpaRepository<OrderDetail, Integer> {
}
