package com.spring.practice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.practice.responce.UserDto;
@Entity
public class User_address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_address_id;
	
	private String address_line1;
	private String address_line2;
	private String city;
	private int postal_code;
	private String country;
	private long phone_nummber;
	private long telephone;
	@OneToOne
	@JoinColumn(name = "user_id")
	
	private User user;
	public int getUser_address_id() {
		return user_address_id;
	}
	public void setUser_address_id(int user_address_id) {
		this.user_address_id = user_address_id;
	}

	public String getAddress_line1() {
		return address_line1;
	}
	public void setAddress_line1(String address_line1) {
		this.address_line1 = address_line1;
	}
	public String getAddress_line2() {
		return address_line2;
	}
	public void setAddress_line2(String address_line2) {
		this.address_line2 = address_line2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(int postal_code) {
		this.postal_code = postal_code;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getPhone_nummber() {
		return phone_nummber;
	}
	public void setPhone_nummber(long phone_nummber) {
		this.phone_nummber = phone_nummber;
	}
	public long getTelephone() {
		return telephone;
	}
	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
