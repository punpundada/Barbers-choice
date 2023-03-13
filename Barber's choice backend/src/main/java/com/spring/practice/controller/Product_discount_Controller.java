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

import com.spring.practice.entities.Product_discount;
import com.spring.practice.responce.AdminDto;
import com.spring.practice.responce.ApiResponce;
import com.spring.practice.responce.Product_discountDto;
import com.spring.practice.service.Product_discountService;
@RestController
@RequestMapping("/api/discount")
public class Product_discount_Controller {
	@Autowired
	 private Product_discountService product_discountService;

	public Product_discount_Controller(Product_discountService product_discountService) {
		super();
		this.product_discountService = product_discountService;
	}

	public Product_discount_Controller() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	@PostMapping
	public ResponseEntity<Product_discountDto> saveProduct_discount(@RequestBody Product_discountDto product_disc)
			{
		Product_discountDto saveProduct_discountDtodto = this.product_discountService.saveProduct_discount(product_disc);
		return new ResponseEntity<>(saveProduct_discountDtodto, HttpStatus.CREATED);
		
		
	     }
	@GetMapping
	public ResponseEntity<List<Product_discountDto>> getAllProduct_discount() {
		return ResponseEntity.ok(this.product_discountService.getAllProduct_discount());
		
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<Product_discountDto>  getProduct_discountById(@PathVariable("id") int id) {
		
		return ResponseEntity.ok(this.product_discountService.getProduct_discountById(id));
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<Product_discountDto> updateProduct_discount(@PathVariable("id") int id,@RequestBody Product_discountDto product_disc) {
		
		Product_discountDto updateDiscount = this.product_discountService.updateProduct_discount(product_disc, id);
		return ResponseEntity.ok(updateDiscount);
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponce> deleteProduct_discount(@PathVariable("id") int id) {
		
		product_discountService.deleteProduct_discount(id);
		
		this.product_discountService.deleteProduct_discount(id);
		return new ResponseEntity<ApiResponce>(new ApiResponce("Admin Deleted successfully",true),HttpStatus.OK);
		
	}

}
