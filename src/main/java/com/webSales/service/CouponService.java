package com.webSales.service;

import com.webSales.dto.CouponDto;

import java.util.List;

public interface CouponService {
    CouponDto createCoupon(CouponDto couponDto);

    CouponDto getCouponById(Integer couponId);

    List<CouponDto> getAllCoupons();

    CouponDto updateCoupon(Integer couponId, CouponDto updateCoupon);

    void deleteCoupon(Integer couponId);
}
