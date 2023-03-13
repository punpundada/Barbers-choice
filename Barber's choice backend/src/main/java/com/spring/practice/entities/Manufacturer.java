package com.spring.practice.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Manufacturer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int manufacturer_id;
	@NotNull
	@Size(min = 3,max = 25,message = "Name should be between 3 to 25 characters")
	private String Manufacturer_name;
	@NotNull
	private String Manufacturer_address;
	@OneToMany(mappedBy = "manufacturer",cascade = CascadeType.ALL)
	
	private List<Product> products;
	
	@OneToOne
	@JoinColumn(name = "login_id")
	
	private Login login;
	
	public int getManufacturer_id() {
		return manufacturer_id;
	}
	public void setManufacturer_id(int manufacturer_id) {
		this.manufacturer_id = manufacturer_id;
	}
	public String getManufacturer_name() {
		return Manufacturer_name;
	}
	public void setManufacturer_name(String manufacturer_name) {
		Manufacturer_name = manufacturer_name;
	}

	public String getManufacturer_address() {
		return Manufacturer_address;
	}
	public void setManufacturer_address(String manufacturer_address) {
		Manufacturer_address = manufacturer_address;
	}

	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}

}
