package com.pedro.picpaychallenge.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.picpaychallenge.domain.User;
import com.pedro.picpaychallenge.domain.enums.UserType;
import com.pedro.picpaychallenge.repository.TransactionRepository;
import com.pedro.picpaychallenge.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class TransferService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void transfer(Long payerId, Long payeeId, BigDecimal value) {
		//busca os usuarios e os "armazena":
		User payer = userRepository.findById(payerId).orElseThrow(()->new RuntimeException("Payer not found"));
		User payee = userRepository.findById(payeeId).orElseThrow(()->new RuntimeException("Payee not found"));
		
		//regras de negocio:
		//verificacao de tipo de usuario
		if(payer.getType().isMerchant()) {
			throw new RuntimeException("Merchant cannot send money");
		}
		//verificacao de saldo:
		if(payer.getBalance().compareTo(value) < 0) {
			throw new RuntimeException("Insufficient balance");
		}
		if(!authorizeTransaction()) {
			throw new RuntimeException("Transaction not authorized");
		}
	}
	
    private boolean authorizeTransaction() {
        return true;
    }
	
}
