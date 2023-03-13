package com.spring.practice.responce;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import com.spring.practice.entities.Cart;
import com.spring.practice.entities.Payment_details;



public class Order_DetailsDto {
	
	
	private int order_details_id;
	private int user_id;
	private int payment_id;
	private double order_details_ammount;
	private String status;
	private LocalDate created_date;
	
private CartDto cartDto;
	
	
	
	
public CartDto getCartDto() {
	return cartDto;
}
public void setCartDto(CartDto cartDto) {
	this.cartDto = cartDto;
}
public Payment_details getPayment_details() {
	return payment_details;
}
public void setPayment_details(Payment_details payment_details) {
	this.payment_details = payment_details;
}
	private Payment_details payment_details;

	
	
	public Order_DetailsDto(int order_details_id, int user_id, int payment_id, double order_details_ammount,
			String status, LocalDate created_date) {
		super();
		this.order_details_id = order_details_id;
		this.user_id = user_id;
		this.payment_id = payment_id;
		this.order_details_ammount = order_details_ammount;
		this.status = status;
		this.created_date = created_date;
	}
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
	@Override
	public String toString() {
		return "Order_DetailsDto [order_details_id=" + order_details_id + ", user_id=" + user_id + ", payment_id="
				+ payment_id + ", order_details_ammount=" + order_details_ammount + ", status=" + status
				+ ", created_date=" + created_date + "]";
	}
	public Order_DetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
