package com.spring.practice.responce;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.spring.practice.entities.Login;
import com.spring.practice.entities.Product;

public class ManfactureDto {
	
	private int manufacturer_id;
	
	private String Manufacturer_name;

	private String Manufacturer_address;
	
	
private List<ProductDto> products;
	
	
	

public List<ProductDto> getProducts() {
	return products;
}

public void setProducts(List<ProductDto> products) {
	this.products = products;
}

public Login getLogin() {
	return login;
}

public void setLogin(Login login) {
	this.login = login;
}

	private Login login;

	

	public ManfactureDto(int manufacturer_id, String manufacturer_name, String manufacturer_address) {
		super();
		this.manufacturer_id = manufacturer_id;
		Manufacturer_name = manufacturer_name;
		Manufacturer_address = manufacturer_address;
	}

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

	@Override
	public String toString() {
		return "ManfactureDto [manufacturer_id=" + manufacturer_id + ", Manufacturer_name=" + Manufacturer_name
				+ ", Manufacturer_address=" + Manufacturer_address + "]";
	}

	public ManfactureDto() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	

}
