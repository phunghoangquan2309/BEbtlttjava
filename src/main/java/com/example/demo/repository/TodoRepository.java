package com.example.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.TodoEntity;
import com.example.demo.entity.UserEntity;
public interface TodoRepository extends JpaRepository<TodoEntity, Long>{
	TodoEntity findOneById(Long id);
	List<TodoEntity> findByUser(UserEntity user);;
}
