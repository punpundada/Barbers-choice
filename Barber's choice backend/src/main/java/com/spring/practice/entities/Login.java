package com.spring.practice.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.val;
@Entity
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int login_id;
	@NotBlank
	@Size(min = 3,max = 15, message = "Username should be between 3 to 15 charactes")
	private String username;
	@NotBlank
	@Size(min = 8, message = "Password should be greater than 8 charactes")
	private String password;
	@Email(message = "Please provide appropriate Email id")
	private String email;
	@NotBlank
	@Size(min = 10,max = 10,message = "Number sholud be exactly 10")
	private long phone_number;
	
	@OneToOne(mappedBy = "login",cascade = CascadeType.ALL)
	private Admin admin;
	
	public int getLogin_id() {
		return login_id;
	}

	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}

	@OneToOne(mappedBy = "login",cascade = CascadeType.ALL)
	private Manufacturer manufacturer;
	
	@OneToOne(mappedBy = "login",cascade = CascadeType.ALL)
		private User user;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}


	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
