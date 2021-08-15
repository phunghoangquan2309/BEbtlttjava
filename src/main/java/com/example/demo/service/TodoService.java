package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.converter.TodoConverter;
import com.example.demo.dto.TodoDTO;
import com.example.demo.entity.TodoEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.TodoRepository;
import com.example.demo.repository.UserRepository;


@Service
public class TodoService {
	@Autowired
	TodoRepository todoRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	TodoConverter todoConverter;
	public List<TodoDTO> getlist(String username) {
		UserEntity userEntity = userRepository.findOneByUsername(username);
		List<TodoEntity> listToDoEntity = todoRepository.findByUser(userEntity);
		List<TodoDTO> listToDoDTO = new ArrayList<TodoDTO>();
		for (int i=0;i<listToDoEntity.size();i++) {
			listToDoDTO.add(todoConverter.toDTO(listToDoEntity.get(i)));
		}
		return listToDoDTO;
	}
	public TodoDTO add(TodoDTO model) {
		UserEntity userEntity = userRepository.findOneByUsername(model.getUsername());
		TodoEntity todoEntity = todoConverter.toEntity(model);
		todoEntity.setUser(userEntity);
		todoEntity = todoRepository.save(todoEntity);
		TodoDTO todoDTO = todoConverter.toDTO(todoEntity);
		return todoDTO;
	}
	public void deleteTodo(Long id) {
		todoRepository.deleteById(id);
	}
	public List<TodoDTO> searchName(String username,String name) {
		UserEntity userEntity = userRepository.findOneByUsername(username);
		List<TodoEntity> listToDoEntity = todoRepository.findByUser(userEntity);
		List<TodoDTO> listToDoDTO = new ArrayList<TodoDTO>();
		for (int i=0;i<listToDoEntity.size();i++) {
			if(listToDoEntity.get(i).getName().equals(name)) {
				listToDoDTO.add(todoConverter.toDTO(listToDoEntity.get(i)));
			}
		}
		return listToDoDTO;
	}
	public TodoDTO updateTodo(TodoDTO model) {
			UserEntity userEntity = userRepository.findOneByUsername(model.getUsername());
			 TodoEntity todoEntity = todoRepository.findOneById(model.getId());
			 todoEntity.setDate(model.getDate());
			 todoEntity.setName(model.getName());
			 todoEntity.setStatus(model.getStatus());
			 todoEntity.setTime(model.getTime());
			 todoEntity.setUser(userEntity);
			todoEntity = todoRepository.save(todoEntity);
			TodoDTO todoDTO = todoConverter.toDTO(todoEntity);
			return todoDTO;
	}
	

}
