package com.springbootcoding.springbootodo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootcoding.springbootodo.dao.TaskstodoDAO;
import com.springbootcoding.springbootodo.model.Taskstodo;



@RestController
@RequestMapping("/task")
public class TaskstodoController{
	
	@Autowired
	TaskstodoDAO taskstodoDAO;
	
	
	/* to save a task*/
	
	@PostMapping("/taskstodos")
	public Taskstodo createTaskstodo(@Valid @RequestBody Taskstodo task) {
		return taskstodoDAO.save(task);
}
	/*display all tasks*/
	@GetMapping("/taskstodos")
	public List<Taskstodo> getALLTaskstodos(){
		return taskstodoDAO.findAll();
	}
	
	/*get tasks by taskid*/
	
	@GetMapping("/taskstodos/{id}")
	public ResponseEntity<Optional<Taskstodo>> getTaskstodoByid(@PathVariable(value="id") Long taskid){
		Optional<Taskstodo> task=taskstodoDAO.findOne(taskid);
		
		if(task==null) {
			return ResponseEntity.notFound().build();
			
		}

	return ResponseEntity.ok().body(task);
	}
	

	
   /*Delete a task*/
	@DeleteMapping("/taskstodos/{id}")
	
	public ResponseEntity<Taskstodo> deleteTaskstodo(@PathVariable(value="id") Long taskid){
		Optional<Taskstodo> task=taskstodoDAO.findOne(taskid)	;
		if(task==null) {
			return ResponseEntity.notFound().build();
		}
		taskstodoDAO.delete(task);
		
		return ResponseEntity.ok().build();
	}

}