package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TodoDTO;

import com.example.demo.service.TodoService;

@RestController
@CrossOrigin
public class TodoAPI {
	@Autowired
	TodoService todoService;
	@GetMapping("/getlist")
	public List<TodoDTO> getlist(@RequestParam String username) {
		return todoService.getlist(username);
	}
	
	@PostMapping("/add")
	public TodoDTO add(@RequestBody TodoDTO model) {
		return todoService.add(model);
	}
	@DeleteMapping("/delete")
	public void delete(@RequestParam Long id) {
		 todoService.deleteTodo(id);
	}
	@GetMapping("/search")
	public List<TodoDTO> getlist(@RequestParam(name = "username") String username,@RequestParam(name = "name") String name) {
		return todoService.searchName(username, name);
	}
	@PutMapping("/update")
	public TodoDTO update(@RequestBody TodoDTO model) {
		return todoService.updateTodo(model);
	}
}
