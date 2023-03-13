package com.spring.practice.responce;

import java.time.LocalDate;

import com.spring.practice.entities.Product;


public class Product_discountDto {
	
	
	private int product_discount_id;
	private String product_discount_name;
	private double product_discount_percentage;
	private boolean product_discount_isActive;
	private LocalDate created_date;
	private LocalDate modified_date;
	private LocalDate Deleted_date;
	
	private ProductDto productsDto;
	
	public ProductDto getProductsDto() {
		return productsDto;
	}
	public void setProductsDto(ProductDto productsDto) {
		this.productsDto = productsDto;
	}
	public Product_discountDto(int product_discount_id, String product_discount_name,
			double product_discount_percentage, boolean product_discount_isActive, LocalDate created_date,
			LocalDate modified_date, LocalDate deleted_date) {
		super();
		this.product_discount_id = product_discount_id;
		this.product_discount_name = product_discount_name;
		this.product_discount_percentage = product_discount_percentage;
		this.product_discount_isActive = product_discount_isActive;
		this.created_date = created_date;
		this.modified_date = modified_date;
		Deleted_date = deleted_date;
	}
	public Product_discountDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getProduct_discount_id() {
		return product_discount_id;
	}
	public void setProduct_discount_id(int product_discount_id) {
		this.product_discount_id = product_discount_id;
	}
	public String getProduct_discount_name() {
		return product_discount_name;
	}
	public void setProduct_discount_name(String product_discount_name) {
		this.product_discount_name = product_discount_name;
	}
	public double getProduct_discount_percentage() {
		return product_discount_percentage;
	}
	public void setProduct_discount_percentage(double product_discount_percentage) {
		this.product_discount_percentage = product_discount_percentage;
	}
	public boolean isProduct_discount_isActive() {
		return product_discount_isActive;
	}
	public void setProduct_discount_isActive(boolean product_discount_isActive) {
		this.product_discount_isActive = product_discount_isActive;
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
	public LocalDate getDeleted_date() {
		return Deleted_date;
	}
	public void setDeleted_date(LocalDate deleted_date) {
		Deleted_date = deleted_date;
	}

	
	


}
