package com.spring.practice.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.practice.entities.Product_discount;
import com.spring.practice.exception.ResourceNotFoundException;
import com.spring.practice.repository.Product_discountRepository;
import com.spring.practice.responce.Product_discountDto;
import com.spring.practice.service.Product_discountService;
@Service
public class Product_discountService_Impl implements Product_discountService {
	@Autowired
	private Product_discountRepository   product_disc_Repo;
	
	@Autowired
	private ModelMapper modelmapper;
	

	public Product_discountService_Impl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product_discountService_Impl(Product_discountRepository product_disc_Repo) {
		super();
		this.product_disc_Repo = product_disc_Repo;
	}

	@Override
	public Product_discountDto saveProduct_discount(Product_discountDto product_discountDto) {
		Product_discount product_discount = this.dtoToProduct_discount(product_discountDto);
		Product_discount product_discountbrand = this.product_disc_Repo.save(product_discount);
		return this.Product_discountDtoToDto(product_discountbrand);
	}

	@Override
	public List<Product_discountDto> getAllProduct_discount() {
		List<Product_discount> product_discount = this.product_disc_Repo.findAll();
		List<Product_discountDto> product_discountdto = product_discount.stream().map(product_disc-> this.Product_discountDtoToDto(product_disc)).collect(Collectors.toList());
		return product_discountdto;
	}

	@Override
	public Product_discountDto getProduct_discountById(int id) {
		Product_discount product_discount =this.product_disc_Repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product_discount", "id", id));
		return this.Product_discountDtoToDto(product_discount);
	}

	@Override
	public Product_discountDto updateProduct_discount(Product_discountDto product_disc, int id) {
		Product_discount existingProductDisc = product_disc_Repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("product_disc", "id", id));
		existingProductDisc.setProduct_discount_name(product_disc.getProduct_discount_name());
		existingProductDisc.setProduct_discount_percentage(product_disc.getProduct_discount_percentage());
		existingProductDisc.setCreated_date(product_disc.getCreated_date());
		existingProductDisc.setModified_date(product_disc.getModified_date());
		existingProductDisc.setDeleted_date(product_disc.getDeleted_date());
		
		Product_discount Product_discount = this.product_disc_Repo.save(existingProductDisc);
		Product_discountDto Product_discountDtodto1 = this.Product_discountDtoToDto(Product_discount);
		
		return Product_discountDtodto1;
		
		
	}

	@Override
	public void deleteProduct_discount(int id) {
		Product_discount product_discount =this.product_disc_Repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product_discount", "id", id));	
		this.product_disc_Repo.delete(product_discount);

	}
	
	
	
	public Product_discount dtoToProduct_discount(Product_discountDto product_discountDto) {
		Product_discount product_discount = this.modelmapper.map(product_discountDto, Product_discount.class);
		return product_discount;
	}
	
	
	public Product_discountDto Product_discountDtoToDto(Product_discount product_discount) {
		Product_discountDto product_discountDto =this.modelmapper.map(product_discount, Product_discountDto.class);
		return product_discountDto;
	}

}
