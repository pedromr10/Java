package com.pedro.eventHandler.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.eventHandler.repositories.CouponRepository;

@Service
public class CouponService {

	@Autowired
	private CouponRepository couponRepo;
}
