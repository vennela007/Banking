package com.ing.bank.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.bank.dto.CustomerDTO;
import com.ing.bank.entity.Customer;

@Service
public class LoginServiceImpl implements LoginService {
@Autowired

	
	public CustomerDTO login(String loginName, String password) {
		CustomerDTO customerDTO = new CustomerDTO();
		Customer customer = employeeRepository.findByLoginIdAndPassword(loginId, password);
		BeanUtils.copyProperties(customer, customerDTO);
		return customerDTO;	
	
	}

}
