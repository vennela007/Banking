/*package com.ing.bank.ingbank.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ing.bank.dto.UserDTO;
import com.ing.bank.entity.User;
import com.ing.bank.repository.UserRepository;
import com.ing.bank.service.UserServiceImpl;

@RunWith(SpringRunner.class)
public class UserServiceTest {
	
	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	
	UserDTO userDTO ;
	User user;
	
	@Before
	public void setup() {
		userDTO = new UserDTO();
		userDTO.setAadharNumber(234523l);
		userDTO.setAccountType("savings");
		userDTO.setAge(21);
		userDTO.setNominee("subha");
		userDTO.setAadharNumber(234523l);
		user = new User();
	}
	
	@Test
	public void customerRegistrationTest() {
		Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
		userDTO = userServiceImpl.userRegistration(userDTO);
		//assertEquals("In progress", userDTO.getStatus());
		
	}
}

*/