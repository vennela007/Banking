package com.ing.bank.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.ing.bank.dto.TransactionDTO;

@Service
public interface TransactionService {

	TransactionDTO fundTransfer(TransactionDTO transactionDTO);

	List<TransactionDTO> getAllTransactions(String accountNumber);
	

}
