package com.pedro.picpaychallenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.picpaychallenge.domain.Transaction;
import com.pedro.picpaychallenge.dtos.TransactionDTO;
import com.pedro.picpaychallenge.services.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping
	public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transactionDto) throws Exception{
		Transaction newTransaction = transactionService.createTransaction(transactionDto);
		return new ResponseEntity<>(newTransaction, HttpStatus.OK);
	}
}
