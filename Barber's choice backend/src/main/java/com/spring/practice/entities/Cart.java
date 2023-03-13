package com.spring.practice.entities;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cart_id;
	private int cart_quantity;
	private LocalDate cart_created_date;
	private LocalDate cart_modified_date;
	@OneToOne
	@JoinColumn(name = "User_Id")
	private User user;
	
	@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
	public List<Product> products;
	
	@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
	private List<Order_details> order_details;
	
	public Cart(int cart_id, int cart_quantity, LocalDate cart_created_date, LocalDate cart_modified_date,
			User user) {
		super();
		this.cart_id = cart_id;

		this.cart_quantity = cart_quantity;
		this.cart_created_date = cart_created_date;
		this.cart_modified_date = cart_modified_date;
		this.user = user;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public List<Order_details> getOrder_details() {
		return order_details;
	}
	public void setOrder_details(List<Order_details> order_details) {
		this.order_details = order_details;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> product) {
		this.products = product;
	}
	
	

	
	
}
