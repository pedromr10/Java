package com.pedro.picpaychallenge.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.picpaychallenge.domain.Transaction;
import com.pedro.picpaychallenge.domain.User;
import com.pedro.picpaychallenge.repository.TransactionRepository;
import com.pedro.picpaychallenge.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class TransferService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthorizationService authorizationService;
	
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
		//verifica se foi autorizado:
	    if(!authorizationService.authorize()) {
	        throw new RuntimeException("Transaction not authorized");
	    }
		
		//caso nenhuma excecao ocorra, acontece a transferencia:
		payer.setBalance(payer.getBalance().subtract(value));
		payee.setBalance(payee.getBalance().add(value));
		userRepository.save(payer);
		userRepository.save(payee);
		
		//cria e salva a transacao:
		Transaction transaction = new Transaction();
		transaction.setAmount(value);
		transaction.setPayee(payee);
		transaction.setPayer(payer);
		transactionRepository.save(transaction);
		
		//envia notificacao:
		try {
		    sendNotification(payer);
		    sendNotification(payee);
		} catch (Exception e) {
		    System.out.println("Notification failed");
		}
	}
	
    private boolean authorizeTransaction() {
        return true;
    }
    
    private void sendNotification(User user) {
        System.out.println("Notifying user: " + user.getEmail());
    }
	
}
