package com.picpay.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.picpay.challenge.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
