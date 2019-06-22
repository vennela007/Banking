package com.ing.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.bank.dto.CustomerDTO;
import com.ing.bank.dto.LoginDTO;
import com.ing.bank.service.LoginService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
@RequestMapping("/api")
public class AdminLoginController {

	@Autowired
	LoginService loginService;

	@PutMapping("/adminlogin")
	public ResponseEntity<CustomerDTO> login(@RequestBody LoginDTO loginDTO) {
		CustomerDTO customerDTO = loginService.login(loginDTO.getLoginName(), loginDTO.getPassword());
		return new ResponseEntity<>(customerDTO, HttpStatus.OK);
	}
}
