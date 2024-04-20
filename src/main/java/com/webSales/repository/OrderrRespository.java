package com.webSales.repository;

import com.webSales.entity.Orderr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderrRespository extends JpaRepository<Orderr, Integer> {
}
