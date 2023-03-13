package com.spring.practice.responce;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.spring.practice.entities.Order_details;
import com.spring.practice.entities.Product;
import com.spring.practice.entities.User;


public class CartDto {
	
	
	public CartDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int cart_id;
	private int cart_quantity;
	private LocalDate cart_created_date;
	private LocalDate cart_modified_date;
	
private UserDto userdto;
	
	
	public List<ProductDto> productsDto;
	
	
	
	public UserDto getUserdto() {
		return userdto;
	}
	public void setUserdto(UserDto userdto) {
		this.userdto = userdto;
	}
	public List<ProductDto> getProductsDto() {
		return productsDto;
	}
	public void setProductsDto(List<ProductDto> productsDto) {
		this.productsDto = productsDto;
	}
	public List<Order_details> getOrder_details() {
		return order_details;
	}
	public void setOrder_details(List<Order_details> order_details) {
		this.order_details = order_details;
	}

	private List<Order_details> order_details;
	
	
	;
	public CartDto(int cart_id, int cart_quantity, LocalDate cart_created_date, LocalDate cart_modified_date) {
		super();
		this.cart_id = cart_id;
		this.cart_quantity = cart_quantity;
		this.cart_created_date = cart_created_date;
		this.cart_modified_date = cart_modified_date;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getCart_quantity() {
		return cart_quantity;
	}
	public void setCart_quantity(int cart_quantity) {
		this.cart_quantity = cart_quantity;
	}
	public LocalDate getCart_created_date() {
		return cart_created_date;
	}
	public void setCart_created_date(LocalDate cart_created_date) {
		this.cart_created_date = cart_created_date;
	}
	public LocalDate getCart_modified_date() {
		return cart_modified_date;
	}
	public void setCart_modified_date(LocalDate cart_modified_date) {
		this.cart_modified_date = cart_modified_date;
	}
	
	
	
	
	
	
	
	
	
	
	

}
