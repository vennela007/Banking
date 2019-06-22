package com.ing.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.bank.dto.AccountDTO;
import com.ing.bank.service.AccountService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("summary/{userId}")
	public ResponseEntity<AccountDTO> getAccountSummary(@PathVariable Long userId) {
		AccountDTO accountDTO = accountService.fetchAccountSummary(userId);
		return new ResponseEntity<>(accountDTO, HttpStatus.FOUND);

	}

}
