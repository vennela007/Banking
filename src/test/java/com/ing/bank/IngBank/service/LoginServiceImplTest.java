package com.ing.bank.IngBank.service;

import java.lang.reflect.InvocationTargetException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.bank.dto.UserDTO;
import com.ing.bank.entity.User;
import com.ing.bank.exception.UserNotFoundException;
import com.ing.bank.repository.UserRepository;
import com.ing.bank.service.LoginServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceImplTest {

	@Mock
	UserRepository userRepository;

	@InjectMocks
	LoginServiceImpl loginServiceImpl;

	User user;

	@Before
	public void setup() {
		user = new User();
		user.setAge(22);
		user.setLoginName("deepika");
		user.setPassword("deep");
	}

	@Test
	public void testLogin() throws UserNotFoundException, IllegalAccessException, InvocationTargetException {
		String loginName = "deepika";
		String password = "deep";
		Mockito.when(userRepository.findByLoginNameAndPassword(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(user);
		UserDTO userDTO = loginServiceImpl.login(loginName, password);
		Assert.assertEquals(22, userDTO.getAge());
	}

	@Test(expected = UserNotFoundException.class)
	public void loginFailure() throws IllegalAccessException, InvocationTargetException, UserNotFoundException {

		String loginName = "test";
		String password = "test";
		Mockito.when(userRepository.findByLoginNameAndPassword(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(null);
		UserDTO userDTO = loginServiceImpl.login(loginName, password);
		Assert.assertEquals(0, userDTO.getAge());
	}

}