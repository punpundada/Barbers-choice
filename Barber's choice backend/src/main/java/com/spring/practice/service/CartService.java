package com.spring.practice.service;

import java.util.List;

import com.spring.practice.responce.CartDto;

public interface CartService {
	
	CartDto saveCart(CartDto cartDto);
	List<CartDto> getAllCarts();
	CartDto getCartById(int id);
	CartDto updateCart(CartDto cartDto, int id);
	void deleteCart(int id);
}
