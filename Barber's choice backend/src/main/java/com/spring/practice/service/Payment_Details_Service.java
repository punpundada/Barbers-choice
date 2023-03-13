package com.spring.practice.service;

import java.util.List;

import com.spring.practice.entities.Payment_details;
import com.spring.practice.responce.Payment_DetailsDto;

public interface Payment_Details_Service {
	
	Payment_DetailsDto savePayment_details(Payment_DetailsDto payment_detailsDto);
	List<Payment_DetailsDto> getAllPayment_details();
	Payment_DetailsDto getPayment_detailsById(int id);
	Payment_DetailsDto updatePayment_details(Payment_DetailsDto payment_detailsDto, int id);
	void deletePayment_details(int id);

}
