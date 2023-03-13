package com.spring.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.practice.entities.Login;

public interface Login_Repository extends JpaRepository<Login, Integer> {
	

}
