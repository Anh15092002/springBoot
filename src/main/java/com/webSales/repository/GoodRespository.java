package com.webSales.repository;

import com.webSales.entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodRespository extends JpaRepository<Good, Integer> {
}
