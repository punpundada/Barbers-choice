package com.spring.practice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.spring.practice.entities.Cart;
import com.spring.practice.exception.ResourceNotFoundException;
import com.spring.practice.repository.CartRepository;
import com.spring.practice.responce.CartDto;
import com.spring.practice.service.CartService;
@Service
@Component
public class CartServiceImpl implements CartService {

	 @Autowired
	private CartRepository cartRepository;
	 
	 @Autowired
		private ModelMapper modelmapper;
	
	public CartServiceImpl(CartRepository cartRepository) {
		super();
		this.cartRepository = cartRepository;
	}
	

	public CartServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public CartDto saveCart(CartDto cartDto) {
		Cart cart = this.dtoTocart(cartDto);
		Cart savecart = this.cartRepository.save(cart);
		return this.CartToDto(savecart);
	}

	@Override
	public List<CartDto> getAllCarts() {
		List<Cart> carts = this.cartRepository.findAll();
		List<CartDto> cartdto = carts.stream().map(cart-> this.CartToDto(cart)).collect(Collectors.toList());
		return cartdto;
	}

	@Override
	public CartDto getCartById(int id) {
		Cart cart =this.cartRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Cart", "id", id));
		return this.CartToDto(cart);
	}

	@Override
	public CartDto updateCart(CartDto cartDto, int id) {
		Cart existingCart = this.cartRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("cart", "id", id));
		existingCart.setCart_created_date(cartDto.getCart_created_date());
		existingCart.setCart_modified_date(cartDto.getCart_modified_date());
		existingCart.setCart_quantity(cartDto.getCart_quantity());;
		
		Cart updateCart = this.cartRepository.save(existingCart);
		CartDto cartdto1 = this.CartToDto(updateCart);
		
		return cartdto1;
	}

	@Override
	public void deleteCart(int id) {
		Cart cart =this.cartRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Cart", "id", id));	
		this.cartRepository.delete(cart);	
	}

	
	
	public Cart dtoTocart(CartDto cartDto) {
		Cart cart = this.modelmapper.map(cartDto, Cart.class);
		return cart;
	}
	
	
	
	public CartDto CartToDto(Cart cart) {
		CartDto cartDto =this.modelmapper.map(cart, CartDto.class);
		return cartDto;
	}

}
