package com.ing.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.bank.dto.UserDTO;
import com.ing.bank.service.ApprovalListService;

@RestController
@CrossOrigin(allowedHeaders = {"*","/"} , origins = {"*","/"})
@RequestMapping("/api")
public class ApprovalListController {
	
	
	@Autowired
	private ApprovalListService approvalListService;
	
	@GetMapping("/listapprovals/userId/{userId}")
	public ResponseEntity<List<UserDTO>> approvalList(@PathVariable long userId )
	{
		List<UserDTO> userDTO=approvalListService.approvalList(userId);
		return new ResponseEntity<>(userDTO,HttpStatus.OK);
	}
	

}
