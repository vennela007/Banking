package com.ing.bank.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.bank.dto.AccountDTO;
import com.ing.bank.dto.AccountRequestDTO;
import com.ing.bank.service.AccountService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AccountController.class)
public class AccountControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	AccountService  accountService;
	
	@Test
	public void approve() throws JsonProcessingException, Exception {
		AccountRequestDTO accountRequestDTO = new AccountRequestDTO();
		accountRequestDTO.setStatus("test");
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccountId(1L);
		Mockito.when(accountService.approve(accountRequestDTO)).thenReturn(accountDTO);
		mockMvc.perform(MockMvcRequestBuilders.put("/api/approve").contentType(MediaType.APPLICATION_JSON).content(mapToJson(accountRequestDTO))).andExpect(MockMvcResultMatchers.status().isAccepted());
	}
	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}
