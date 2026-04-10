package com.pedro.picpaychallenge.services;

import com.pedro.picpaychallenge.repositories.UserRepo;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pedro.picpaychallenge.domain.Transaction;
import com.pedro.picpaychallenge.domain.User;
import com.pedro.picpaychallenge.dtos.TransactionDTO;
import com.pedro.picpaychallenge.repositories.TransactionRepo;

@Service
public class TransactionService {
	
	
	@Autowired
	private UserService userService;
	@Autowired
	private TransactionRepo transactionRepo;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private NotificationService notificationService;
	
	public Transaction createTransaction(TransactionDTO transactionDTO) throws Exception{
		User payer = userService.findUserById(transactionDTO.payerId());
		User payee = userService.findUserById(transactionDTO.payeeId());
		userService.validateTransaction(payer, transactionDTO.amount());
		
		if(!isTransactionAuthorized()) {
			throw new Exception("Transaction not authorized");
		}
		
		Transaction newTransaction = new Transaction(null, payer, payee, transactionDTO.amount(), LocalDateTime.now());
		
		transactionRepo.save(newTransaction);
		
		payer.setBalance(payer.getBalance().subtract(transactionDTO.amount()));
		payee.setBalance(payee.getBalance().add(transactionDTO.amount()));
		
		transactionRepo.save(newTransaction);
		userService.saveUser(payer);
		userService.saveUser(payee);
		
		notificationService.sendNotification(payer, "Transaction paid");
		notificationService.sendNotification(payee, "Transaction received");
		
		return newTransaction;
	}
	
	public boolean isTransactionAuthorized() {
		
		String url = "https://util.devi.tools/api/v2/authorize";
		ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
		
		String responseStatus = (String) response.getBody().get("status");
		Map<String, Object> data = (Map<String, Object>) response.getBody().get("data");
		Boolean responseAuthorization = (Boolean) data.get("authorization");
		
		if(responseStatus.equalsIgnoreCase("success") && Boolean.TRUE.equals(responseAuthorization)) {
			return true;
		}
		else {
			return false;
		}
		
	}
}
