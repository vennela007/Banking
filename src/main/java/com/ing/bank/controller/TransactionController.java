package com.ing.bank.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.bank.dto.AccountNumberDTO;
import com.ing.bank.dto.TransactionDTO;
import com.ing.bank.service.TransactionService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
@RequestMapping("/api")
public class TransactionController {
	private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);
	@Autowired
	TransactionService transactionService;

	@PutMapping("/transactions")
	public ResponseEntity<List<TransactionDTO>> getAllTransactions(@RequestBody AccountNumberDTO accountNumberDTO) {
		logger.info("inside transaction list");
		List<TransactionDTO> transactionList = transactionService.getAllTransactions(accountNumberDTO.getAccountNumber());
		return new ResponseEntity<>(transactionList, HttpStatus.OK);

	}

	@PostMapping("/transfer")
	public ResponseEntity<TransactionDTO> fundTransfer(@RequestBody TransactionDTO transactionDTO) {
		logger.info("fund transfer");
		TransactionDTO responseTransactionDTO = transactionService.fundTransfer(transactionDTO);
		return new ResponseEntity<>(responseTransactionDTO, HttpStatus.CREATED);

	}

}
