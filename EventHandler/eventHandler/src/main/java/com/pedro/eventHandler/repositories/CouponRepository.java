package com.pedro.eventHandler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedro.eventHandler.domain.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long>{

}
