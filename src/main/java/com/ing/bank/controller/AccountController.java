package com.ing.bank.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.bank.dto.AccountDTO;
import com.ing.bank.dto.AccountNumberDTO;
import com.ing.bank.dto.AccountRequestDTO;
import com.ing.bank.service.AccountService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class AccountController {
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private AccountService accountService;

	@GetMapping("summary/{userId}")
	public ResponseEntity<List<AccountDTO>> getAccountSummary(@PathVariable Long userId) {
		List<AccountDTO> accountDTOs = accountService.fetchAccountSummary(userId);
		return new ResponseEntity<>(accountDTOs, HttpStatus.OK);

	}

	@PutMapping("/approve")
	public ResponseEntity<AccountDTO> approve(@RequestBody AccountRequestDTO accountRequestDTO) {
		logger.info("approve");
		AccountDTO accountDTO = accountService.approve(accountRequestDTO);
		return new ResponseEntity<>(accountDTO, HttpStatus.ACCEPTED);
	}

	@PutMapping("/accounts")
	public ResponseEntity<List<AccountDTO>> getAccounts(@RequestBody AccountNumberDTO accountNumberDTO) {
		List<AccountDTO> listAccountDTO = accountService.fetchAccounts(accountNumberDTO.getAccountNumber());
		return new ResponseEntity<>(listAccountDTO, HttpStatus.OK);
	}
}
