package com.spring.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.practice.entities.Cart;
import com.spring.practice.responce.AdminDto;
import com.spring.practice.responce.ApiResponce;
import com.spring.practice.responce.CartDto;
import com.spring.practice.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
	@Autowired
	private CartService cartService;

	public @Autowired CartController(@RequestBody CartService cartService) {
		super();
		this.cartService = cartService;
	}

	public CartController() {
		super();
		// TODO Auto-generated constructor stub
	}
	@PostMapping
	public ResponseEntity<CartDto> saveCart(CartDto cart) {
		CartDto saveCartDto = this.cartService.saveCart(cart);
		return new ResponseEntity<>(saveCartDto, HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<CartDto> getAllCarts() {
		return cartService.getAllCarts();
	}
	@GetMapping("{id}")
	public ResponseEntity<List<CartDto>> getCartById(@PathVariable("id") int id) {
		return ResponseEntity.ok(this.cartService.getAllCarts());
	}
	@PutMapping("{id}")
	public ResponseEntity<CartDto> UpdateCart(@PathVariable("{id}") int id, @RequestBody Cart cart) {
		return ResponseEntity.ok(this.cartService.getCartById(id));
	}
	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponce>deleteCart(@PathVariable("id") int id) {
		
	    cartService.deleteCart(id);
		this.cartService.deleteCart(id);
		return new ResponseEntity<ApiResponce>(new ApiResponce("Cart Deleted successfully",true),HttpStatus.OK);
	}
	
	
	
}
