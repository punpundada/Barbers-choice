package com.spring.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.practice.entities.Brand;
import com.spring.practice.entities.User_address;
import com.spring.practice.responce.AdminDto;
import com.spring.practice.responce.ApiResponce;
import com.spring.practice.responce.User_AddressDto;
import com.spring.practice.service.User_AddressService;
@RestController
@RequestMapping("/api/UserAddress")
public class User_address_Controller {
	@Autowired
	 private User_AddressService user_AddressService;

	public User_address_Controller(User_AddressService user_AddressService) {
		super();
		this.user_AddressService = user_AddressService;
	}

	public User_address_Controller() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	@PostMapping
	public ResponseEntity<User_AddressDto> saveA_user_address(@RequestBody User_AddressDto user_AddressDto) {
		
		User_AddressDto saveUser_AddressDtodto = this.user_AddressService.saveA_user_address(user_AddressDto);
		return new ResponseEntity<>(saveUser_AddressDtodto, HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<User_AddressDto>> getAlluser_address() {
		return ResponseEntity.ok(this.user_AddressService.getAlluser_address());
		
	}
	@GetMapping("{id}")
	public ResponseEntity<User_AddressDto> getuser_addressById(@PathVariable("id") int id) {
		return ResponseEntity.ok(this.user_AddressService.getuser_addressById(id));
		
	}
	@PutMapping("{id}")
	public ResponseEntity<User_AddressDto> updateUser_address(@PathVariable("id") int id,@RequestBody User_AddressDto user_AddressDto) {
		
		User_AddressDto updateUser_add = this.user_AddressService.updateUser_address(user_AddressDto, id);
		return ResponseEntity.ok(updateUser_add);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponce> deleteUser_address(@PathVariable("id") int id) {
		
		user_AddressService.deleteUser_address(id);
		
		this.user_AddressService.deleteUser_address(id);
		return new ResponseEntity<ApiResponce>(new ApiResponce(" user address Deleted successfully",true),HttpStatus.OK);
		
	}

}
