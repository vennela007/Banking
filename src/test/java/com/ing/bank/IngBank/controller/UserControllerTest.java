package com.ing.bank.ingbank.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.bank.controller.UserController;
import com.ing.bank.dto.UserDTO;
import com.ing.bank.entity.User;
import com.ing.bank.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class)
public class UserControllerTest {
	@Autowired
	MockMvc mockMvc;

	@MockBean
	UserService userService;
	UserDTO userDTO;
	User user;
	@Test
	public void userRegistrationTest() throws Exception {
		userDTO = new UserDTO();
		userDTO.setAccountType("savings");
		user = new User();
		user.setAccountType("savings");
		Mockito.when(userService.userRegistration(userDTO)).thenReturn(userDTO);
		mockMvc.perform(post("/api/registration").contentType(MediaType.APPLICATION_JSON).content(asJsonString(userDTO)))
		.andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
