package com.spring.practice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.practice.entities.Payment_details;
import com.spring.practice.exception.ResourceNotFoundException;
import com.spring.practice.repository.Payment_detailsRepository;
import com.spring.practice.responce.Payment_DetailsDto;
import com.spring.practice.service.Payment_Details_Service;
@Service
public class Payment_details_Impl implements Payment_Details_Service {

	@Autowired
	private Payment_detailsRepository payment_details_repo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	public Payment_details_Impl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment_details_Impl(Payment_detailsRepository payment_details_repo) {
		super();
		this.payment_details_repo = payment_details_repo;
	}

	@Override
	public Payment_DetailsDto savePayment_details(Payment_DetailsDto payment_DetailsDto) {
		Payment_details payment_details = this.dtoToPayment_details(payment_DetailsDto);
		Payment_details savepayment_details = this.payment_details_repo.save(payment_details);
		return this.Payment_detailsToDto(savepayment_details);
	}

	@Override
	public List<Payment_DetailsDto> getAllPayment_details() {
		// TODO Auto-generated method stub
		
		List<Payment_details> payment_details = this.payment_details_repo.findAll();
		List<Payment_DetailsDto> payment_detailsdto = payment_details.stream().map(payment_d-> this.Payment_detailsToDto(payment_d)).collect(Collectors.toList());
		return payment_detailsdto;
	}

	@Override
	public Payment_DetailsDto getPayment_detailsById(int id) {
		Payment_details payment_details =this.payment_details_repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Payment_DetailsDto", "id", id));
		return this.Payment_detailsToDto(payment_details);
	}

	@Override
	public Payment_DetailsDto updatePayment_details(Payment_DetailsDto payment_DetailsDto, int id) {
		// TODO Auto-generated method stub
		Payment_details existingPaymentDetails = payment_details_repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("payment_details", "id", id));
		         existingPaymentDetails.setAmmount(payment_DetailsDto.getAmmount());
		         existingPaymentDetails.setStatus(payment_DetailsDto.getStatus());
		         existingPaymentDetails.setModified_date(payment_DetailsDto.getModified_date());
		         
		         Payment_details updateAdmin = this.payment_details_repo.save(existingPaymentDetails);
		 		Payment_DetailsDto branddto1 = this.Payment_detailsToDto(updateAdmin);
		 		
		 		return branddto1;
	}
		         

	@Override
	public void deletePayment_details(int id) {
		Payment_details payment_details =this.payment_details_repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Payment_details", "id", id));	
		this.payment_details_repo.delete(payment_details);
			

	}
	
	
	
	public Payment_details dtoToPayment_details(Payment_DetailsDto payment_detailsDto) {
		Payment_details payment_details = this.modelmapper.map(payment_detailsDto, Payment_details.class);
		return payment_details;
	}
	
	
	
	public Payment_DetailsDto Payment_detailsToDto(Payment_details payment_details) {
		Payment_DetailsDto payment_detailsDto =this.modelmapper.map(payment_details, Payment_DetailsDto.class);
		return payment_detailsDto;
	}

}
