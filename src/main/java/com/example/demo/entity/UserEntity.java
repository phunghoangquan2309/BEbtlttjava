package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table
public class UserEntity {
	@Id
	private String username;
	@Column
	private String password;
	@Column
	private String fullname;
	@Column 
	private Integer age;
	@Column
	private String email;

    @OneToMany(mappedBy = "user")
    private List<TodoEntity> todolist = new ArrayList<TodoEntity>();
    

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<TodoEntity> getTodolist() {
		return todolist;
	}

	public void setTodolist(List<TodoEntity> todolist) {
		this.todolist = todolist;
	}
    
}
