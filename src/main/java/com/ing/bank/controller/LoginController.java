package com.ing.bank.controller;

import java.lang.reflect.InvocationTargetException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.bank.dto.LoginDTO;
import com.ing.bank.dto.UserDTO;
import com.ing.bank.exception.UserNotFoundException;
import com.ing.bank.service.LoginService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
@RequestMapping("/api")
public class LoginController {
	private static final Logger lOGGER = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	LoginService loginService;

	@PutMapping("/login")
	public ResponseEntity<UserDTO> login(@RequestBody LoginDTO loginDTO) throws UserNotFoundException, IllegalAccessException, InvocationTargetException {
		lOGGER.info("inside login");
		UserDTO userDTO = loginService.login(loginDTO.getLoginName(), loginDTO.getPassword());
		return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}
}
