package com.ing.bank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.bank.dto.TransactionDTO;

@RestController
@CrossOrigin(allowedHeaders = {"*","/"} , origins = {"*","/"})
@RequestMapping("/api")
public class TransactionController {
	
	@PostMapping("/transfer")
	public ResponseEntity<TransactionDTO> fundTransfer(@RequestBody TransactionDTO transactionDTO){
		
		return null;
	}
}
