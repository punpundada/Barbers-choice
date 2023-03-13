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
import com.spring.practice.entities.Payment_details;
import com.spring.practice.responce.AdminDto;
import com.spring.practice.responce.ApiResponce;
import com.spring.practice.responce.Payment_DetailsDto;
import com.spring.practice.service.Payment_Details_Service;

@RestController
@RequestMapping("/api/paymentDetails")
public class Payment_details_Controller {
	@Autowired
	 private Payment_Details_Service   payment_details_dervice;

	public Payment_details_Controller(Payment_Details_Service payment_details_dervice) {
		super();
		this.payment_details_dervice = payment_details_dervice;
	}

	public Payment_details_Controller() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	
	@PostMapping
	public ResponseEntity<Payment_DetailsDto> savePayment_details(@RequestBody Payment_DetailsDto payment_DetailsDto){
		Payment_DetailsDto savePayment_DetailsDtodto = this.payment_details_dervice.savePayment_details(payment_DetailsDto);
		return new ResponseEntity<>(savePayment_DetailsDtodto, HttpStatus.CREATED);
		
		
	}
	
	
	public ResponseEntity<List<Payment_DetailsDto>> getAllPayment_details() {
		return ResponseEntity.ok(this.payment_details_dervice.getAllPayment_details());
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Payment_DetailsDto> getPayment_detailsById(@PathVariable("id") int Id) {
		
		return ResponseEntity.ok(this.payment_details_dervice.getPayment_detailsById(Id));
			
	}
	@PutMapping("{id}")
	public ResponseEntity<Payment_DetailsDto> updatePayment_details(@PathVariable("id") int id, @RequestBody Payment_DetailsDto payment_DetailsDto) {
		
		Payment_DetailsDto updatePayment_DetailsDto = this.payment_details_dervice.updatePayment_details(payment_DetailsDto, id);
		return ResponseEntity.ok(updatePayment_DetailsDto);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponce> deletePayment_details(@PathVariable("id") int id) {
		
		payment_details_dervice.deletePayment_details(id);
		
		this.payment_details_dervice.deletePayment_details(id);
		return new ResponseEntity<ApiResponce>(new ApiResponce("Admin Deleted successfully",true),HttpStatus.OK);
		
		
	}
	
	
}
