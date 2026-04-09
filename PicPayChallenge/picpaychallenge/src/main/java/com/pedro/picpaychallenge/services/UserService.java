package com.pedro.picpaychallenge.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.picpaychallenge.domain.User;
import com.pedro.picpaychallenge.enums.UserType;
import com.pedro.picpaychallenge.repositories.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	public void validateTransaction(User payer, BigDecimal value) throws Exception{
		//verificacao de tipo de usuario:
		if(payer.getType() != UserType.COMMON) {
			throw new Exception("Merchant User cannot pay");
		}
		//verificacao de saldo:
		if(payer.getBalance().compareTo(value) < 0) {
			throw new Exception("Insufficient balance");
		}
	}
	
	public User findUserById(Long id) throws Exception{
		return userRepo.findById(id).orElseThrow(()-> new Exception("User not found"));
	}
	
	public void saveUser(User user) {
		userRepo.save(user);
	}
}
