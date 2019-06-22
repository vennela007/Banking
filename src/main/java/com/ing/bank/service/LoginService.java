package com.ing.bank.service;

import com.ing.bank.dto.CustomerDTO;

public interface LoginService {

	CustomerDTO login(String loginName, String password);

}
