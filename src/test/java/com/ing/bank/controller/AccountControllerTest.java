package com.ing.bank.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.bank.dto.AccountDTO;
import com.ing.bank.dto.AccountRequestDTO;
import com.ing.bank.service.AccountService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AccountController.class, secure = false)
public class AccountControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AccountService accountService;

	@Test
	public void approve() throws JsonProcessingException, Exception {
		AccountRequestDTO accountRequestDTO = new AccountRequestDTO();
		accountRequestDTO.setStatus("test");
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccountId(1L);
		Mockito.when(accountService.approve(accountRequestDTO)).thenReturn(accountDTO);
		mockMvc.perform(MockMvcRequestBuilders.put("/api/approve").contentType(MediaType.APPLICATION_JSON)
				.content(mapToJson(accountRequestDTO))).andExpect(MockMvcResultMatchers.status().isAccepted());
	}

	@Test
	public void getSummary() throws Exception {
		List<AccountDTO> accountDTOs = new ArrayList<>();
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccountId(1L);
		accountDTO.setAccountNumber("aac111");
		accountDTO.setAccountType("saving");
		accountDTO.setBalance(35353);
		accountDTO.setCreationDate(LocalDate.now());
		accountDTO.setStatus("approved");
		accountDTOs.add(accountDTO);
		Mockito.when(accountService.fetchAccountSummary(Mockito.anyLong())).thenReturn(accountDTOs);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/summary/1").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String InputType = this.mapToJson(accountDTO);
		String OutputType = result.getResponse().getContentAsString();
		MockHttpServletResponse response = result.getResponse();
		System.out.println(OutputType.equals(InputType));

	}

	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

}
