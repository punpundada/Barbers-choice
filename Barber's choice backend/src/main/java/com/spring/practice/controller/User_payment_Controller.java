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

import com.spring.practice.entities.User_payment;
import com.spring.practice.responce.AdminDto;
import com.spring.practice.responce.ApiResponce;
import com.spring.practice.responce.User_paymentDto;
import com.spring.practice.service.User_PaymentService;
@RestController
@RequestMapping("/UserPayment")
public class User_payment_Controller {
	@Autowired
	private User_PaymentService user_PaymentService;

	public User_payment_Controller(User_PaymentService user_PaymentService) {
		super();
		this.user_PaymentService = user_PaymentService;
	}

	public User_payment_Controller() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping
	public ResponseEntity<User_paymentDto> saveUserPayment(@RequestBody User_paymentDto user_paymentDto) {
		User_paymentDto user_paymentDto1 = this.user_PaymentService.saveUserPayment(user_paymentDto);
		return new ResponseEntity<>(user_paymentDto1, HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<User_paymentDto>> getAllUserPayment() {
		return ResponseEntity.ok(this.user_PaymentService.getAllUserPayment());
	}
	@GetMapping("{id}")
	public ResponseEntity<User_paymentDto> getuserPaymnetById(@PathVariable("id") int id) {
		return ResponseEntity.ok(this.user_PaymentService.getuserPaymnetById(id));
	}
	@PutMapping("{id}")
	public ResponseEntity<User_paymentDto> updateuserPayment(@PathVariable("id") int id,@RequestBody User_paymentDto user_paymentDto) {
		User_paymentDto user_paymentDto2 = this.user_PaymentService.updateuserPayment(user_paymentDto, id);
		return ResponseEntity.ok(user_paymentDto2);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponce> deleteuserPayment(@PathVariable("id") int id) {
		user_PaymentService.deleteuserPayment(id);
		
		this.user_PaymentService.deleteuserPayment(id);
		return new ResponseEntity<ApiResponce>(new ApiResponce("User Payment  Deleted successfully",true),HttpStatus.OK);
	
	}

}
