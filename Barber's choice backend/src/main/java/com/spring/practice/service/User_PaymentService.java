package com.spring.practice.service;

import java.util.List;

import com.spring.practice.entities.User_payment;
import com.spring.practice.responce.User_paymentDto;

public interface User_PaymentService {
	User_paymentDto saveUserPayment(User_paymentDto userPaymentDto);
	List<User_paymentDto> getAllUserPayment();
	User_paymentDto getuserPaymnetById(int id);
	User_paymentDto updateuserPayment(User_paymentDto adminDto, int id);
	void deleteuserPayment(int id);
	
	

}
