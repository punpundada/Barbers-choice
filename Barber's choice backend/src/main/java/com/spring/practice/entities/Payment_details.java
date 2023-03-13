package com.spring.practice.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Payment_details {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int payment_details_id;
	private double ammount;
	private String provider;
	private String status;
	private LocalDate created_date;
	private LocalDate modified_date;
	@OneToOne
	@JoinColumn(name = "order_id")
	
	private Order_details details;
	
	public int getPayment_details_id() {
		return payment_details_id;
	}
	public void setPayment_details_id(int payment_details_id) {
		this.payment_details_id = payment_details_id;
	}
	public double getAmmount() {
		return ammount;
	}
	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
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
	public LocalDate getModified_date() {
		return modified_date;
	}
	public void setModified_date(LocalDate modified_date) {
		this.modified_date = modified_date;
	}
	public Order_details getDetails() {
		return details;
	}
	public void setDetails(Order_details details) {
		this.details = details;
	}
	
}
