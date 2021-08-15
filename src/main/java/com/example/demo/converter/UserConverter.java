package com.example.demo.converter;

import org.springframework.stereotype.Component;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserEntity;

@Component
public class UserConverter {
	public UserDTO toDTO(UserEntity u) {
		UserDTO uDTO = new UserDTO();
		uDTO.setAge(u.getAge());
		uDTO.setEmail(u.getEmail());
		uDTO.setFullname(u.getFullname());
		uDTO.setPassword(u.getPassword());
		uDTO.setUsername(u.getUsername());
		return uDTO;
	}
	public UserEntity toEntity(UserDTO model) {
		UserEntity uEntity = new UserEntity();
		uEntity.setAge(model.getAge());
		uEntity.setEmail(model.getEmail());
		uEntity.setFullname(model.getFullname());
		uEntity.setPassword(model.getPassword());
		uEntity.setUsername(model.getUsername());
		return uEntity;
	}
}
