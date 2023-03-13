package com.spring.practice.responce;

import java.time.LocalDate;

import com.spring.practice.entities.Login;
import com.spring.practice.entities.User;

public class AdminDto {
	
	private int admin_id;
	private String admin_namefirst;
	private String admin_namelast;
	private LocalDate admin_last_login;
	private LoginDto loginDto;
	private UserDto userDto;
	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public AdminDto(int admin_id, String admin_namefirst, String admin_namelast, LocalDate admin_last_login) {
		super();
		this.admin_id = admin_id;
		this.admin_namefirst = admin_namefirst;
		this.admin_namelast = admin_namelast;
		this.admin_last_login = admin_last_login;
	}
	
	public LoginDto getLoginDto() {
		return loginDto;
	}
	
	public void setLoginDto(LoginDto loginDto) {
		this.loginDto = loginDto;
	}

	public AdminDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_namefirst() {
		return admin_namefirst;
	}
	public void setAdmin_namefirst(String admin_namefirst) {
		this.admin_namefirst = admin_namefirst;
	}
	public String getAdmin_namelast() {
		return admin_namelast;
	}
	public void setAdmin_namelast(String admin_namelast) {
		this.admin_namelast = admin_namelast;
	}
	public LocalDate getAdmin_last_login() {
		return admin_last_login;
	}
	public void setAdmin_last_login(LocalDate admin_last_login) {
		this.admin_last_login = admin_last_login;
	}
	
	

	

}
