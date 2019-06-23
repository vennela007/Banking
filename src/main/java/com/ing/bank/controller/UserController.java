package com.ing.bank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.bank.dto.UserDTO;
import com.ing.bank.service.UserService;
import com.ing.bank.service.UserServiceImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class UserController {
	private static final Logger lOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserService customerService;

	@PostMapping("/registration")
	public ResponseEntity<UserDTO> userRegistration(@RequestBody UserDTO customerDTO) {
		UserDTO responseCustomerDTO = customerService.userRegistration(customerDTO);

		lOGGER.info("success");
		return new ResponseEntity<>(responseCustomerDTO, HttpStatus.CREATED);
	}
}
