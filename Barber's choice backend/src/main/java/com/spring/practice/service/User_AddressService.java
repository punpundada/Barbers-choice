package com.spring.practice.service;

import java.util.List;

import com.spring.practice.entities.User_address;
import com.spring.practice.responce.User_AddressDto;



public interface User_AddressService {

	User_AddressDto saveA_user_address(User_AddressDto user_addressDto);
	List<User_AddressDto> getAlluser_address();
	User_AddressDto getuser_addressById(int id);
	User_AddressDto updateUser_address(User_AddressDto user_addressDto, int id);
	void deleteUser_address(int id);
	
	
}
