package com.pedro.eventHandler.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.eventHandler.domain.Coupon;
import com.pedro.eventHandler.services.CouponService;

@RestController
@RequestMapping("/coupons")
public class CouponController {
	
	@Autowired
	private CouponService couponService;
	
	//get all coupons:
	@GetMapping
	public ResponseEntity<List<Coupon>> findAllCoupons(){
		List<Coupon> allCouponsList = couponService.findAllCoupons();
		return ResponseEntity.ok(allCouponsList);
	}
	
	//add coupon to event:
	@PostMapping("/{eventId}/coupons")
	public ResponseEntity<Coupon> addCouponToEvent(@PathVariable Long eventId, @RequestBody Coupon coupon){
		Coupon savedCoupon = couponService.addCouponToEvent(eventId, coupon);
		return ResponseEntity.status(201).body(savedCoupon);
	}
	
}
