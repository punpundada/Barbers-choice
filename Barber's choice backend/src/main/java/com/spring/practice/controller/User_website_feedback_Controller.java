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
import com.spring.practice.entities.User_website_feedback;
import com.spring.practice.responce.AdminDto;
import com.spring.practice.responce.ApiResponce;
import com.spring.practice.responce.User_website_feedbackDto;
import com.spring.practice.service.User_website_feedback_Service;
@RestController
@RequestMapping("/api/feedback")
public class User_website_feedback_Controller {
	@Autowired
	private User_website_feedback_Service user_website_feedback_Service;

	public User_website_feedback_Controller(User_website_feedback_Service user_website_feedback_Service) {
		super();
		this.user_website_feedback_Service = user_website_feedback_Service;
	}

	
	public User_website_feedback_Controller() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	@PostMapping
	public ResponseEntity<User_website_feedbackDto> save_uwf(@RequestBody User_website_feedbackDto user_website_feedbackDto) {
		User_website_feedbackDto saveUser_website_feedbackDto= this.user_website_feedback_Service.save_uwf(user_website_feedbackDto);
		return new ResponseEntity<>(saveUser_website_feedbackDto, HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<User_website_feedbackDto>> getAllFeedback() {
		return ResponseEntity.ok(this.user_website_feedback_Service.getAllFeedback());
	}
	@GetMapping("{id}")
	public ResponseEntity<User_website_feedbackDto> getUserById(@PathVariable("id") int id) {
		return ResponseEntity.ok(this.user_website_feedback_Service.getUserById(id));
	}
	@PutMapping("{id}")
	public ResponseEntity<User_website_feedbackDto> update_feedback(@PathVariable("id") int id,@RequestBody User_website_feedbackDto user_website_feedbackDto) {
		User_website_feedbackDto UpdateUser_website_feedbackDto = this.user_website_feedback_Service.update_feedback(user_website_feedbackDto, id);
		return ResponseEntity.ok(UpdateUser_website_feedbackDto);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponce> deleteBrand(@PathVariable("id") int id) {
		user_website_feedback_Service.deleteUserFeedbackById(id);
		
		this.user_website_feedback_Service.deleteUserFeedbackById(id);
		return new ResponseEntity<ApiResponce>(new ApiResponce("Admin Deleted successfully",true),HttpStatus.OK);
	
	}

}
