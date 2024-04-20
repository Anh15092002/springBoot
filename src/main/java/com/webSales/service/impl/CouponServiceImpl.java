package com.webSales.service.impl;

import com.webSales.dto.CouponDto;
import com.webSales.entity.Coupon;
import com.webSales.exception.ResourceNotFoundException;
import com.webSales.mapper.CouponMapper;
import com.webSales.repository.CouponRepository;
import com.webSales.service.CouponService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CouponServiceImpl implements CouponService {
    private CouponRepository couponRepository;

    @Override
    public CouponDto createCoupon(CouponDto couponDto) {
        Coupon coupon = CouponMapper.mapToCoupon(couponDto);
        Coupon saveCoupon = couponRepository.save(coupon);
        return CouponMapper.mapToCouponDto(saveCoupon);
    }

    @Override
    public CouponDto getCouponById(Integer couponId) {
        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Coupon is not exist with given id: " + couponId));
        return CouponMapper.mapToCouponDto(coupon);
    }

    @Override
    public List<CouponDto> getAllCoupons() {
        List<Coupon> coupons = couponRepository.findAll();
        return coupons.stream().map((coupon) -> CouponMapper.mapToCouponDto(coupon))
                .collect(Collectors.toList());
    }

    @Override
    public CouponDto updateCoupon(Integer couponId, CouponDto updateCoupon) {
        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Coupon is not exist with given id: " + couponId));
        coupon.setCode(updateCoupon.getCode());
        coupon.setDiscount(updateCoupon.getDiscount());
        coupon.setExpriation_date(updateCoupon.getExpriation_date());
        Coupon updateCouponObj = couponRepository.save(coupon);
        return CouponMapper.mapToCouponDto(updateCouponObj);
    }

    @Override
    public void deleteCoupon(Integer couponId) {
        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Coupon is not exist with given id:" + couponId));
        couponRepository.deleteById(couponId);
    }
}
