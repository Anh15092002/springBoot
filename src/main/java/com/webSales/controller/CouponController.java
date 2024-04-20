package com.webSales.controller;

import com.webSales.dto.CouponDto;
import com.webSales.service.CouponService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/coupon")
public class CouponController {
    private CouponService couponService;

    //Build Add Coupon REST API
    @PostMapping
    public ResponseEntity<CouponDto> createCoupon(@RequestBody CouponDto couponDto) {
        CouponDto savedEmployee = couponService.createCoupon(couponDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    //Build Get Coupon REST API
    @GetMapping("{id}")
    public ResponseEntity<CouponDto> getCouponById(@PathVariable("id") Integer couponId) {
        CouponDto couponDto = couponService.getCouponById(couponId);
        return ResponseEntity.ok(couponDto);
    }

    //Build Get All Coupon REST API
    @GetMapping
    public ResponseEntity<List<CouponDto>> getAllCoupons() {
        List<CouponDto> coupons = couponService.getAllCoupons();
        return ResponseEntity.ok(coupons);
    }

    //Build Update Coupon REST API
    @PutMapping("{id}")
    public ResponseEntity<CouponDto> updateCoupon(@PathVariable("id") Integer couponId,
                                                      @RequestBody CouponDto updateCoupon){
        CouponDto couponDto = couponService.updateCoupon(couponId, updateCoupon);
        return ResponseEntity.ok(couponDto);
    }

    //Build Delete Coupon REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCoupon(@PathVariable("id") Integer couponId) {
        couponService.deleteCoupon(couponId);
        return ResponseEntity.ok("Couppon deleted successfully!.");
    }
}
