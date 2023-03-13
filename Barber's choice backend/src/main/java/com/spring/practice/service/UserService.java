package com.spring.practice.service;

import java.util.List;


import com.spring.practice.responce.UserDto;

public interface UserService {
	UserDto saveUser(UserDto userDto);
	List<UserDto> getAllUser();
	UserDto updateUser( UserDto u1,int id);
	UserDto getUserById(int id);
	void deleteUser(int id);
	

}
