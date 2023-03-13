package com.spring.practice.responce;

import java.util.List;

import com.spring.practice.entities.Product;

public class BrandDto {

	

	public BrandDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int brand_id;
	private String brand_name;
	private List<ProductDto> productsDto;
	
	
	
	
	
	public List<ProductDto> getProductsDto() {
		return productsDto;
	}
	public void setProductsDto(List<ProductDto> productsDto) {
		this.productsDto = productsDto;
	}
	public BrandDto(int brand_id, String brand_name) {
		super();
		this.brand_id = brand_id;
		this.brand_name = brand_name;
		
		
		
	}
	@Override
	public String toString() {
		return "BrandDto [brand_id=" + brand_id + ", brand_name=" + brand_name + ", products=" +  "]";
	}
	
	
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
	
}
