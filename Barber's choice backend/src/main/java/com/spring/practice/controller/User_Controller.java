package com.spring.practice.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.spring.practice.responce.ApiResponce;
import com.spring.practice.responce.UserDto;
import com.spring.practice.service.UserService;
@RestController
@RequestMapping("/api/user")
public class User_Controller {
	@Autowired
	private UserService userService;


	
	@PostMapping
	public ResponseEntity<UserDto> saveUser(@Valid @RequestBody UserDto userDto) {
		UserDto saveUserDtodto = this.userService.saveUser(userDto);
		return new ResponseEntity<>(saveUserDtodto, HttpStatus.CREATED);
		
		
	}
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUser() {
		return ResponseEntity.ok(this.userService.getAllUser());
		
		
	}
	@GetMapping("{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("id") int id) {
		return ResponseEntity.ok(this.userService.getUserById(id)); 
		
	}
	@PutMapping("{id}")
	public ResponseEntity<UserDto> updateUser(@Valid @PathVariable("id") int id,@RequestBody UserDto userDto) {
		
		UserDto updateUser = this.userService.updateUser(userDto, id);
		return ResponseEntity.ok(updateUser);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponce> deleteUser(@PathVariable("id") int id) {
		
		
		
		this.userService.deleteUser(id);
		return new ResponseEntity<ApiResponce>(new ApiResponce("User Deleted successfully",true),HttpStatus.OK);
		
}
	

}
