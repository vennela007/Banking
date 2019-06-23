package com.ing.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.bank.dto.TransactionDTO;
import com.ing.bank.entity.Transaction;
import com.ing.bank.exception.TransactionNotFoundException;
import com.ing.bank.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	public List<TransactionDTO> getAllTransactions(String accountNumber) {
		List<TransactionDTO> transactionDtoList = new ArrayList<TransactionDTO>();
		
		List<Transaction> transactionList=transactionRepository.findByAccountNumber(accountNumber);
		if(transactionList.size()>0) {
		for (Transaction transaction : transactionList) {
			TransactionDTO transactionDTO = new TransactionDTO();
			BeanUtils.copyProperties(transaction, transactionDTO);
			transactionDtoList.add(transactionDTO);
			
		}
		}
		else {
			throw new TransactionNotFoundException();
		}
		return transactionDtoList;
		
	}

	
}
