package com.example.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.example.demo.converter.UserConverter;
import com.example.demo.dto.AccountDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;
	
	public String register(UserDTO model) {
		UserEntity ue = userRepository.findOneByUsername(model.getUsername());
		if(ue != null) {
			return "Username already used";
		}
		UserEntity userEntity = userConverter.toEntity(model);
		userRepository.save(userEntity);
		return "register success";
	}
	public ResponseEntity<AccountDTO> login(AccountDTO model) {
		UserEntity ue = userRepository.findOneByUsername(model.getUsername());	
		if(ue == null) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		if(ue.getPassword().equals(model.getPassword())==true) {
			return new ResponseEntity<AccountDTO>(model,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
	
}
