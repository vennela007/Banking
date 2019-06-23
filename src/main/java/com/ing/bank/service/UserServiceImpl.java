package com.ing.bank.service;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.bank.dto.UserDTO;
import com.ing.bank.entity.User;
import com.ing.bank.exception.RegistrationFailedException;
import com.ing.bank.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger lOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDTO userRegistration(UserDTO userDTO) throws RegistrationFailedException {

		
		if(userDTO !=null) {
			userDTO.setStatus("In progress");
			userDTO.setRole("user");
			User customer = new User();
			BeanUtils.copyProperties(userDTO, customer);
			customer.setCreationDate(LocalDate.now());
			customer = userRepository.save(customer);
			lOGGER.info("data saved..");
			BeanUtils.copyProperties(customer, userDTO);
		return userDTO;
		}
		else {
			throw new RegistrationFailedException();
		}
	}

}
