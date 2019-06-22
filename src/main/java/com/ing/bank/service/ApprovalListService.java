package com.ing.bank.service;

import java.util.List;

import com.ing.bank.dto.UserDTO;

public interface ApprovalListService {
	
	public List<UserDTO> approvalList(long userId);

}
