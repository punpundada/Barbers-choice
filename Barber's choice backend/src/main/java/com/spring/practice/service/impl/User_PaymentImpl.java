package com.spring.practice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.practice.entities.Brand;
import com.spring.practice.entities.User_payment;
import com.spring.practice.exception.ResourceNotFoundException;
import com.spring.practice.repository.User_paymentRepository;
import com.spring.practice.responce.BrandDto;
import com.spring.practice.responce.User_paymentDto;
import com.spring.practice.service.User_PaymentService;

@Service
public class User_PaymentImpl implements User_PaymentService
{
	@Autowired
	private User_paymentRepository user_payment_repo;
	
	@Autowired
	private ModelMapper modelmapper;
	

	public User_PaymentImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User_PaymentImpl(User_paymentRepository user_payment_repo) {
		super();
		this.user_payment_repo = user_payment_repo;
	}

	@Override
	public User_paymentDto saveUserPayment(User_paymentDto user_paymentDto) {
		User_payment user_payment = this.dtoTobuser_payment(user_paymentDto);
		User_payment saveUser_payment = this.user_payment_repo.save(user_payment);
		return this.user_paymentDto(saveUser_payment);
	}

	@Override
	public List<User_paymentDto> getAllUserPayment() {
		List<User_payment> user_payment = (List<User_payment>) this.user_payment_repo.findAll();
		List<User_paymentDto> User_paymentDto = user_payment.stream().map(user_payment1-> this.user_paymentDto(user_payment1)).collect(Collectors.toList());
		return User_paymentDto;
	}

	@Override
	public User_paymentDto getuserPaymnetById(int id) {
		User_payment user_payment =this.user_payment_repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("user_payment", "id", id));
		return this.user_paymentDto(user_payment); 
	}

	@Override
	public User_paymentDto updateuserPayment(User_paymentDto user_paymentDto1, int id) {
		User_payment u_Payment = user_payment_repo.findById(id).orElseThrow(()->new ResourceNotFoundException("user_pay", "id", id));
		u_Payment.setProvider(user_paymentDto1.getProvider());
		User_payment updateUser_payment = this.user_payment_repo.save(u_Payment);
		User_paymentDto User_paymentDto1 = this.user_paymentDto(updateUser_payment);
		
		return User_paymentDto1;
	}

	@Override
	public void deleteuserPayment(int id) {
		User_payment user_payment =this.user_payment_repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User_payment", "id", id));	
		this.user_payment_repo.delete(user_payment);
			
		
		
		
	}
	
	public User_payment dtoTobuser_payment(User_paymentDto user_paymentDto) {
		User_payment user_payment = this.modelmapper.map(user_paymentDto, User_payment.class);
		return user_payment;
	}
	
	
	public User_paymentDto user_paymentDto(User_payment user_payment) {
		User_paymentDto user_paymentDto =this.modelmapper.map(user_payment, User_paymentDto.class);
		return user_paymentDto;
	}

	
	

}
