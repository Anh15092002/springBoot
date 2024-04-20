package com.webSales.mapper;

import com.webSales.dto.CouponDto;
import com.webSales.entity.Coupon;

public class CouponMapper {
    public static CouponDto mapToCouponDto(Coupon coupon) {
        return new CouponDto(
                coupon.getId(),
                coupon.getCode(),
                coupon.getDiscount(),
                coupon.getExpriation_date()
        );
    }

    public static Coupon mapToCoupon(CouponDto couponDto) {
        return new Coupon(
                couponDto.getId(),
                couponDto.getCode(),
                couponDto.getDiscount(),
                couponDto.getExpriation_date()
        );
    }
}
