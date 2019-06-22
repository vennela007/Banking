package com.ing.bank.service;

import org.springframework.stereotype.Service;

import com.ing.bank.dto.UserDTO;

@Service
public interface UserService {

	UserDTO userRegistration(UserDTO customerDTO);

}
