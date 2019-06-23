package com.ing.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.bank.dto.UserDTO;
import com.ing.bank.entity.User;
import com.ing.bank.repository.UserRepository;

@Service
public class ApprovalListServiceImpl implements ApprovalListService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserDTO> approvalList(long userId) {

		User user = userRepository.findByUserId(userId);

		List<User> userList = null;
		List<UserDTO> userListDto = new ArrayList<>();

		if (user.getRole().equalsIgnoreCase("admin") || user.getRole().equals("admin")) {

			userList = userRepository.findByStatusAndRole("In progress","user");

			for (int i = 0; i < userList.size(); i++) {
				UserDTO userDTO = new UserDTO();
				userDTO.setUserId(userList.get(i).getUserId());
				userDTO.setAadharNumber(userList.get(i).getAadharNumber());
				userDTO.setAccountType(userList.get(i).getAccountType());
				userDTO.setAddress(userList.get(i).getAddress());
				userDTO.setAge(userList.get(i).getAge());
				userDTO.setCreationDate(userList.get(i).getCreationDate());
				userDTO.setEmail(userList.get(i).getEmail());
				userDTO.setLoginName(userList.get(i).getLoginName());
				userDTO.setMobileNumber(userList.get(i).getMobileNumber());
				userDTO.setNominee(userList.get(i).getNominee());
				userDTO.setNomineeRelation(userList.get(i).getNomineeRelation());
				userDTO.setPassword(userList.get(i).getPassword());
				userDTO.setRole(userList.get(i).getRole());
				userDTO.setStatus(userList.get(i).getStatus());
				userListDto.add(userDTO);
			}
		} else {
			// throw new exception()
		}

		return userListDto;
	}

}
