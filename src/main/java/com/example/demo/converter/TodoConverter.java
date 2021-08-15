package com.example.demo.converter;

import org.springframework.stereotype.Component;

import com.example.demo.dto.TodoDTO;

import com.example.demo.entity.TodoEntity;

@Component
public class TodoConverter {
	public TodoEntity toEntity(TodoDTO todoDTO,TodoEntity todoEntity) {
		todoEntity.setDate(todoDTO.getDate());
		todoEntity.setName(todoDTO.getName());
		todoEntity.setTime(todoDTO.getTime());
		todoEntity.setStatus(todoDTO.getStatus());
		return todoEntity;
	}
	public TodoEntity toEntity(TodoDTO todoDTO) {
		TodoEntity todoEntity = new TodoEntity();
		todoEntity.setDate(todoDTO.getDate());
		todoEntity.setName(todoDTO.getName());
		todoEntity.setTime(todoDTO.getTime());
		todoEntity.setStatus(todoDTO.getStatus());
		return todoEntity;
	}
	public TodoDTO toDTO(TodoEntity todoEntity) {
		TodoDTO todoDTO = new TodoDTO();
		todoDTO.setId(todoEntity.getId());
		todoDTO.setDate(todoEntity.getDate());
		todoDTO.setName(todoEntity.getName());
		todoDTO.setTime(todoEntity.getTime());
		todoDTO.setUsername(todoEntity.getUser().getUsername());
		todoDTO.setStatus(todoEntity.getStatus());
		return todoDTO;
	}
}
