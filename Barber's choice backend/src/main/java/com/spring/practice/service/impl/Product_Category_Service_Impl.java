package com.spring.practice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.practice.entities.Product_category;
import com.spring.practice.exception.ResourceNotFoundException;
import com.spring.practice.repository.Product_Category_Repository;
import com.spring.practice.responce.Product_categoryDto;
import com.spring.practice.service.Product_Category_Service;
@Service
public class Product_Category_Service_Impl implements Product_Category_Service {
	@Autowired
	private Product_Category_Repository product_category_repo;
	

	@Autowired
	private ModelMapper modelmapper;
	
	

	public Product_Category_Service_Impl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product_Category_Service_Impl(Product_Category_Repository product_category_repo) {
		super();
		this.product_category_repo = product_category_repo;
	}

	@Override
	public Product_categoryDto saveProduct_category(Product_categoryDto product_categoryDto) {
		Product_category product_category = this.dtoToProduct_category(product_categoryDto);
		Product_category saveproduct_category = this.product_category_repo.save(product_category);
		return this.product_categoryDto(saveproduct_category);
	}

	@Override
	public List<Product_categoryDto> getAllAProduct_category() {
		List<Product_category> product_category = this.product_category_repo.findAll();
		List<Product_categoryDto> product_categorydto = product_category.stream().map(product_cat-> this.product_categoryDto(product_cat)).collect(Collectors.toList());
		return product_categorydto;
	}
	

	@Override
	public Product_categoryDto getProduct_categoryById(int id) {
		// TODO Auto-generated method stub
		Product_category product_category =this.product_category_repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product_category", "id", id));
		return this.product_categoryDto(product_category);
		
	}

	@Override
	public Product_categoryDto updateProduct_category(Product_categoryDto product_categoryDto, int id) {
		Product_category existingProductCat = product_category_repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("product_category_repo", "id", id));
		     existingProductCat.setCategory_description(product_categoryDto.getCategory_description());
		     existingProductCat.setModified_date(product_categoryDto.getModified_date());
		     existingProductCat.setDeleted_date(product_categoryDto.getDeleted_date());
		     
		     
		     Product_category updateProduct_category = this.product_category_repo.save(existingProductCat);
		     Product_categoryDto Product_categoryDtodto1 = this.product_categoryDto(updateProduct_category);
				
				return Product_categoryDtodto1;
	}

	@Override
	public void deleteProduct_category(int id) {
		Product_category product_category =this.product_category_repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product_category", "id", id));	
		this.product_category_repo.delete(product_category);
	}
	
	
	
	
	
	
	public Product_category dtoToProduct_category(Product_categoryDto product_categoryDto) {
		Product_category Product_category= this.modelmapper.map(product_categoryDto, Product_category.class);
		return Product_category;
	}
	
	
	
	public Product_categoryDto product_categoryDto(Product_category product_category) {
		Product_categoryDto product_categoryDto =this.modelmapper.map(product_category, Product_categoryDto.class);
		return product_categoryDto;
	}

}
