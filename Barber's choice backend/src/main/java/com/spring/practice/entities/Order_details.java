package com.spring.practice.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Order_details {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_details_id;
	private int user_id;
	private int payment_id;
	private double order_details_ammount;
	private String status;
	private LocalDate created_date;
	
	@ManyToOne
	@JoinColumn(name = "cart_id")
	
	private Cart cart;
	
	@OneToOne(mappedBy = "details",cascade = CascadeType.ALL)
	
	private Payment_details payment_details;

	public int getOrder_details_id() {
		return order_details_id;
	}

	public void setOrder_details_id(int order_details_id) {
		this.order_details_id = order_details_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public double getOrder_details_ammount() {
		return order_details_ammount;
	}

	public void setOrder_details_ammount(double order_details_ammount) {
		this.order_details_ammount = order_details_ammount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getCreated_date() {
		return created_date;
	}

	public void setCreated_date(LocalDate created_date) {
		this.created_date = created_date;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Payment_details getPayment_details() {
		return payment_details;
	}

	public void setPayment_details(Payment_details payment_details) {
		this.payment_details = payment_details;
	}
	
	
	
}
