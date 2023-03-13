package com.spring.practice.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.spring.practice.entities.Login;
import com.spring.practice.exception.ResourceNotFoundException;
import com.spring.practice.repository.Login_Repository;
import com.spring.practice.responce.LoginDto;
import com.spring.practice.service.Login_Service;


@Service
@Component
public class Login_Service_Impl implements Login_Service {
	@Autowired
	private Login_Repository login_repo;
	
	@Autowired
	private ModelMapper modelmapper;
	

	public Login_Service_Impl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login_Service_Impl(Login_Repository login_repo) {
		super();
		this.login_repo = login_repo;
	}

	@Override
	public LoginDto saveLogin(LoginDto loginDto) {
		// TODO Auto-generated method stub
		Login login = this.dtoToLogin(loginDto);
		Login savelogin = this.login_repo.save(login);
		return this.LoginToDto(savelogin);
	}

	@Override
	public List<LoginDto> getAllLogins() {
		// TODO Auto-generated method stub
		List<Login> logins = this.login_repo.findAll();
		List<LoginDto> logindto = logins.stream().map(login-> this.LoginToDto(login)).collect(Collectors.toList());
		return logindto;
	}

	@Override
	public LoginDto getLoginById(int id) {
		// TODO Auto-generated method stub
		Login login =this.login_repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Login", "id", id));
		return this.LoginToDto(login);
	}

	@Override
	public LoginDto updateLogin(LoginDto loginDto, int id) {
		Login existingLogin = login_repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("login", "id", id));
		existingLogin.setUsername(loginDto.getUsername());
		existingLogin.setPassword(loginDto.getPassword());
		existingLogin.setEmail(loginDto.getEmail());
		existingLogin.setPhone_number(loginDto.getPhone_number());
		
		Login updateLogin = this.login_repo.save(existingLogin);
		LoginDto logindto1 = this.LoginToDto(updateLogin);
		
		return logindto1;
	}

	@Override
	public void deleteLogin(int id) {
		// TODO Auto-generated method stub
		Login login =this.login_repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("login", "id", id));	
		this.login_repo.delete(login);	
		
	}


	public Login dtoToLogin(LoginDto loginDto) {
		Login login = this.modelmapper.map(loginDto, Login.class);
		return login;
	}
	
	
	
	public LoginDto LoginToDto(Login login) {
		LoginDto loginDto =this.modelmapper.map(login, LoginDto.class);
		return loginDto;
	}

	
}
