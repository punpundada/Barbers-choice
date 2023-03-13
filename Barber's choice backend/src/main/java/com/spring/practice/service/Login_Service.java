package com.spring.practice.service;

import java.util.List;

import com.spring.practice.entities.Login;
import com.spring.practice.responce.LoginDto;

public interface Login_Service {
	
	LoginDto saveLogin(LoginDto loginDto);
	List<LoginDto> getAllLogins();
	LoginDto getLoginById(int id);
	LoginDto updateLogin(LoginDto loginDto, int id);
	void deleteLogin(int id);

}
