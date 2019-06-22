package com.ing.bank.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.bank.dto.UserDTO;
import com.ing.bank.entity.User;
import com.ing.bank.repository.UserRepository;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	UserRepository userRepository;
	

	public UserDTO login(String loginName, String password) {
		UserDTO userDTO = new UserDTO();
		User user = userRepository.findByLoginNameAndPassword(loginName, password);
		
		BeanUtils.copyProperties(user, userDTO);
		return userDTO;

	}

}
