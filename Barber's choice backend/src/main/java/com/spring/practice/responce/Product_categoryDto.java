package com.spring.practice.responce;

import java.time.LocalDate;
import java.util.List;

import com.spring.practice.entities.Product;



public class Product_categoryDto {
	

	
	private int category_id;
	private String category_name;
	private String category_description;
	private LocalDate created_date;
	private LocalDate modified_date;
	private LocalDate Deleted_date;
	
	private List<ProductDto> productsDto;
	
	
	public List<ProductDto> getProductsDto() {
		return productsDto;
	}
	public void setProductsDto(List<ProductDto> productsDto) {
		this.productsDto = productsDto;
	}
	public Product_categoryDto(int category_id, String category_name, String category_description,
			LocalDate created_date, LocalDate modified_date, LocalDate deleted_date) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
		this.category_description = category_description;
		this.created_date = created_date;
		this.modified_date = modified_date;
		Deleted_date = deleted_date;
	}
	public Product_categoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getCategory_description() {
		return category_description;
	}
	public void setCategory_description(String category_description) {
		this.category_description = category_description;
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
