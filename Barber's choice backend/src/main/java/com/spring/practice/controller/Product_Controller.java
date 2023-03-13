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

import com.spring.practice.entities.Product;
import com.spring.practice.responce.AdminDto;
import com.spring.practice.responce.ApiResponce;
import com.spring.practice.responce.ProductDto;
import com.spring.practice.service.ProductService;
@RestController
@RequestMapping("/api/product")
public class Product_Controller {
	@Autowired
	 private ProductService productService;

	public Product_Controller(ProductService productService) {
		super();
		this.productService = productService;
	}

	public Product_Controller() {
		super();
		// TODO Auto-generated constructor stub
	}
       
	
	@PostMapping
	public ResponseEntity<ProductDto> saveProduct(ProductDto product) {
	
		ProductDto productDto = this.productService.saveProduct(product);
		return new ResponseEntity<>(productDto, HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<ProductDto>> getAllProducts() {
		return ResponseEntity.ok(this.productService.getAllProducts());
		
	}
	@GetMapping("{id}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable("id") int id) {
		return ResponseEntity.ok(this.productService.getProductById(id));
		
	}
	@PutMapping("{id}")
	public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") int id,@RequestBody ProductDto product) {
		
		ProductDto updateProductDto = this.productService.updateProduct(product, id);
		return ResponseEntity.ok(updateProductDto);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponce> deleteProduct(@PathVariable("id") int id) {
		
		productService.deleteProduct(id);
		
		this.productService.deleteProduct(id);
		return new ResponseEntity<ApiResponce>(new ApiResponce("Product Deleted successfully",true),HttpStatus.OK);
		
	}
	 
	
	

}
