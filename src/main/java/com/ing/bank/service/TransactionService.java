package com.ing.bank.service;

import org.springframework.stereotype.Service;

import com.ing.bank.dto.TransactionDTO;

@Service
public interface TransactionService {

	TransactionDTO fundTransfer(TransactionDTO transactionDTO);
	
}
