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
import com.spring.practice.entities.Order_details;
import com.spring.practice.responce.AdminDto;
import com.spring.practice.responce.ApiResponce;
import com.spring.practice.responce.Order_DetailsDto;
import com.spring.practice.service.Order_details_Service;

@RestController
@RequestMapping("/api/orderDetails")
public class Order_details_Controller {
	@Autowired
	private Order_details_Service order_details_Service;
	

	
	public Order_details_Controller() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Order_details_Controller(Order_details_Service order_details_Service) {
		super();
		this.order_details_Service = order_details_Service;
	}



	@PostMapping
	public ResponseEntity<Order_DetailsDto> saveOrder_details(@RequestBody Order_DetailsDto order_DetailsDto){
		Order_DetailsDto saveOrderdto = this.order_details_Service.saveOrder_details(order_DetailsDto);
		return new ResponseEntity<>(saveOrderdto, HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Order_DetailsDto> getAllOrder_details() {
		return order_details_Service.getAllOrder_details();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<List<Order_DetailsDto>> getAdminById(@PathVariable("id") int OrderId) {
		return ResponseEntity.ok(this.order_details_Service.getAllOrder_details());
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<Order_DetailsDto> updateAdmin(@PathVariable("id") int id, @RequestBody Order_DetailsDto order_DetailsDto) {
		Order_DetailsDto updateOrder_DetailsDto = this.order_details_Service.updateOrder_details(order_DetailsDto, id);
		return ResponseEntity.ok(updateOrder_DetailsDto);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponce> deleteAdmin(@PathVariable("id") int id) {
		
		order_details_Service.deleteOrder_details(id);
		
		this.order_details_Service.deleteOrder_details(id);
		return new ResponseEntity<ApiResponce>(new ApiResponce("Order Deleted successfully",true),HttpStatus.OK);
	}
	
	
	

}
