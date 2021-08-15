package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AccountDTO;
import com.example.demo.dto.UserDTO;

import com.example.demo.service.UserService;

@RestController
@CrossOrigin
public class UserAPI {
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public String Register(@RequestBody UserDTO userDTO) {
		return userService.register(userDTO);
	}
	@PostMapping("/login")
	public ResponseEntity<AccountDTO> login(@RequestBody AccountDTO account) {
		return userService.login(account);
	}
	
}
