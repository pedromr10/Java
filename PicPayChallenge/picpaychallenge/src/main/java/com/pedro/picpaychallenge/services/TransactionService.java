package com.pedro.picpaychallenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.picpaychallenge.repositories.TransactionRepo;
import com.pedro.picpaychallenge.repositories.UserRepo;

@Service
public class TransactionService {
	
	@Autowired
	private UserService userService;
	@Autowired
	private TransactionRepo transactionRepo;
	// 36min
}
