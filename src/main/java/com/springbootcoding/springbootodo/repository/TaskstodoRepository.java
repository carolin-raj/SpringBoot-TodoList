package com.springbootcoding.springbootodo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootcoding.springbootodo.model.Taskstodo;



public interface TaskstodoRepository extends JpaRepository <Taskstodo, Long> {

	void deleteById(Optional<Taskstodo> task);
	
}

