package com.pedro.eventHandler.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.eventHandler.domain.Coupon;
import com.pedro.eventHandler.domain.Event;
import com.pedro.eventHandler.repositories.CouponRepository;
import com.pedro.eventHandler.repositories.EventRepository;

@Service
public class CouponService {

	@Autowired
	private CouponRepository couponRepo;
	
	@Autowired
	private EventRepository eventRepo;
	
	
	//get all coupons:
	public List<Coupon> findAllCoupons(){
		return couponRepo.findAll();
	}
	
	//add coupon to event:
	public Coupon addCouponToEvent(Long eventId, Coupon coupon) {
		Event event = eventRepo.findById(eventId).orElseThrow(()-> new RuntimeException("Event not found"));
		coupon.setEvent(event);
		
		return couponRepo.save(coupon);
	}
}
