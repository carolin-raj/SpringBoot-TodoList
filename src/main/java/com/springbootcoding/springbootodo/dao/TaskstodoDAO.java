package com.springbootcoding.springbootodo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springbootcoding.springbootodo.model.Taskstodo;
import com.springbootcoding.springbootodo.repository.TaskstodoRepository;
@Service
public class TaskstodoDAO {
	
	TaskstodoRepository taskstodoRepository;
	
	/*to add a task*/
	
	public Taskstodo save(Taskstodo task) {
		return taskstodoRepository.save(task);
	}
	
	/*to list all task*/
	
	public List<Taskstodo> findAll(){
		return taskstodoRepository.findAll();
	}
	
	/* get a task by id*/
	public Optional<Taskstodo> findOne(Long task) {
		return taskstodoRepository.findById(task);
	}
	
	/*delete a task*/
	public void delete(Optional<Taskstodo> task) {
		 taskstodoRepository.deleteById(task);
	}
   
}
