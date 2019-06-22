package com.ing.bank.service;

import com.ing.bank.dto.UserDTO;

public interface LoginService {

	UserDTO login(String loginName, String password);

}
