package com.spring.practice.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int brand_id;
	private String brand_name;
	@OneToMany(mappedBy = "brand",cascade = CascadeType.ALL)
	
	private List<Product> products;
	
	
	public int getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}
	
	public String getBrand_name() {
		return brand_name;
	}
	
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
