package com.spring.practice.responce;

import java.time.LocalDate;

import com.spring.practice.entities.Order_details;


public class Payment_DetailsDto {
	
	
	private int payment_details_id;
	private double ammount;
	private String provider;
	private String status;
	private LocalDate created_date;
	private LocalDate modified_date;
	private Order_DetailsDto details;
	
	
	public Order_DetailsDto getDetails() {
		return details;
	}
	public void setDetails(Order_DetailsDto details) {
		this.details = details;
	}
	public Payment_DetailsDto(int payment_details_id, double ammount, String provider, String status,
			LocalDate created_date, LocalDate modified_date) {
		super();
		this.payment_details_id = payment_details_id;
		this.ammount = ammount;
		this.provider = provider;
		this.status = status;
		this.created_date = created_date;
		this.modified_date = modified_date;
	}
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
	@Override
	public String toString() {
		return "Payment_DetailsDto [payment_details_id=" + payment_details_id + ", ammount=" + ammount + ", provider="
				+ provider + ", status=" + status + ", created_date=" + created_date + ", modified_date="
				+ modified_date + "]";
	}
	public Payment_DetailsDto() {
		super();
		
	}
	
	
	

}
