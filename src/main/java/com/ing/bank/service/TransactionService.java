package com.ing.bank.service;

import java.util.List;

import com.ing.bank.dto.TransactionDTO;

public interface TransactionService {

	List<TransactionDTO> getAllTransactions(String accountNumber);

}
