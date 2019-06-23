package com.ing.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.bank.dto.TransactionDTO;
import com.ing.bank.service.TransactionService;

@RestController
@CrossOrigin(allowedHeaders = {"*","/"} , origins = {"*","/"})
@RequestMapping("/api")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService; 
	
	@PostMapping("/transfer")
	public ResponseEntity<TransactionDTO> fundTransfer(@RequestBody TransactionDTO transactionDTO){
		System.out.println("Inside controller");
		TransactionDTO responseTransactionDTO = transactionService.fundTransfer(transactionDTO);
		return new ResponseEntity<>(responseTransactionDTO,HttpStatus.CREATED);
	}
}
