package com.spring.practice.responce;

import com.spring.practice.entities.User;

public class User_AddressDto {
	
private int user_address_id;
	
	private String address_line1;
	private String address_line2;
	private String city;
	private int postal_code;
	private String country;
	private long phone_nummber;
	private long telephone;
	private UserDto userDto;
	
	
	
	public UserDto getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	public User_AddressDto(int user_address_id, String address_line1, String address_line2, String city,
			int postal_code, String country, long phone_nummber, long telephone) {
		super();
		this.user_address_id = user_address_id;
		this.address_line1 = address_line1;
		this.address_line2 = address_line2;
		this.city = city;
		this.postal_code = postal_code;
		this.country = country;
		this.phone_nummber = phone_nummber;
		this.telephone = telephone;
	}
	public User_AddressDto() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	
	

}
