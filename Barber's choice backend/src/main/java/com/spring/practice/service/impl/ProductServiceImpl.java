package com.spring.practice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.practice.entities.Product;
import com.spring.practice.exception.ResourceNotFoundException;
import com.spring.practice.repository.ProductRepository;
import com.spring.practice.responce.ProductDto;
import com.spring.practice.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	

	public ProductServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductServiceImpl(ProductRepository productRepo) {
		super();
		this.productRepo = productRepo;
	}

	@Override
	public ProductDto saveProduct(ProductDto productDto) {
		Product product = (Product) this.dtoTobProduct(productDto);
		Product saveproduct= this.productRepo.save(product);
		
		return this.productToDto(saveproduct);

	}

	@Override
	public List<ProductDto> getAllProducts() {
		List<Product> product = this.productRepo.findAll();
		List<ProductDto> productdto = product.stream().map(product1-> this.productToDto(product1)).collect(Collectors.toList());
		return productdto;
	}

	@Override
	public ProductDto getProductById(int id) {
		Product product =this.productRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product", "id", id));
		return this.productToDto(product);
	}

	@Override
	public ProductDto updateProduct(ProductDto productDto, int id) {
		// TODO Auto-generated method stub
		Product existingProduct = productRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("product", "id", id));
		existingProduct.setProduct_name(productDto.getProduct_name());
		existingProduct.setProduct_description(productDto.getProduct_description());
		existingProduct.setProduct_price(productDto.getProduct_price());
		existingProduct.setCreated_date(productDto.getCreated_date());
		existingProduct.setModified_date(productDto.getModified_date());
		existingProduct.setDeleted_date(productDto.getDeleted_date());
		
		Product updateProduct = this.productRepo.save(existingProduct);
		ProductDto Productdto1 = this.productToDto(updateProduct);
		
		return Productdto1;
		
		
		
	}

	@Override
	public void deleteProduct(int id) {
		Product product =this.productRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product", "id", id));	
		this.productRepo.delete(product);	
		
	}
	
	
	
	
	public ProductService dtoTobProduct(ProductDto productDto) {
		ProductService productService = this.modelmapper.map(productDto, ProductService.class);
		return productService;
	}
	
	
	public ProductDto productToDto(Product product) {
		ProductDto productDto =this.modelmapper.map(product, ProductDto.class);
		return productDto;
	}
	

}
