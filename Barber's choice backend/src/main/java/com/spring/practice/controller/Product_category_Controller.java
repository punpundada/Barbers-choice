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

import com.spring.practice.entities.Product_category;
import com.spring.practice.responce.AdminDto;
import com.spring.practice.responce.ApiResponce;
import com.spring.practice.responce.Product_categoryDto;
import com.spring.practice.service.Product_Category_Service;
@RestController
@RequestMapping("/api/Category")
public class Product_category_Controller {
	@Autowired
	private Product_Category_Service product_category_service ;

	public Product_category_Controller(Product_Category_Service product_category_service) {
		super();
		this.product_category_service = product_category_service;
	}

	public Product_category_Controller() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@PostMapping
	public ResponseEntity<Product_categoryDto> aveProduct_category(@RequestBody Product_categoryDto product_cat) {
		Product_categoryDto saveProduct_categoryDtodto = this.product_category_service.saveProduct_category(product_cat);
		return new ResponseEntity<>(saveProduct_categoryDtodto, HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<Product_categoryDto>> getAllAProduct_category() {
		return ResponseEntity.ok(this.product_category_service.getAllAProduct_category());
	}
	@GetMapping("{id}")
	public ResponseEntity<Product_categoryDto> getProduct_categoryById(@PathVariable("id") int id) {
		return ResponseEntity.ok(this.product_category_service.getProduct_categoryById(id));
	
	}
	@PutMapping("{id}")
	public ResponseEntity<Product_categoryDto> updateProduct_category(@PathVariable("id") int id,@RequestBody Product_categoryDto product_category) {
		Product_categoryDto updateProduct_categoryDto = this.product_category_service.updateProduct_category(product_category, id);
		return ResponseEntity.ok(updateProduct_categoryDto);
		
	}
	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponce> deleteProduct_category( @PathVariable("id") int id) {
		
		product_category_service.deleteProduct_category(id);
		
		this.product_category_service.deleteProduct_category(id);
		return new ResponseEntity<ApiResponce>(new ApiResponce("Product category Deleted successfully",true),HttpStatus.OK);
		
	}

}
