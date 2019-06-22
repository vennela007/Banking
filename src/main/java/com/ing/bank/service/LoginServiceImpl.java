package com.ing.bank.service;

import java.lang.reflect.InvocationTargetException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.bank.dto.UserDTO;
import com.ing.bank.entity.User;
import com.ing.bank.exception.LoginNotFoundException;
import com.ing.bank.repository.UserRepository;

@Service
public class LoginServiceImpl implements LoginService {
	private static final Logger lOGGER = LoggerFactory.getLogger(LoginService.class);
	@Autowired
	UserRepository userRepository;

	public UserDTO login(String loginName, String password) throws IllegalAccessException, InvocationTargetException{
		lOGGER.info(loginName);
		UserDTO userDTO = new UserDTO();
		User user = userRepository.findByLoginNameAndPassword(loginName, password);
		if (user != null) {
			BeanUtils.copyProperties(user, userDTO);
		} else {
			throw new LoginNotFoundException();
		}
		return userDTO;

	}

}
