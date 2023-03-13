package com.spring.practice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.spring.practice.entities.Brand;
import com.spring.practice.exception.ResourceNotFoundException;
import com.spring.practice.repository.BrandRepository;
import com.spring.practice.responce.BrandDto;
import com.spring.practice.service.BrandService;
@Service
@Component
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	private ModelMapper modelmapper;
	
	
	public BrandServiceImpl(BrandRepository brandRepository) {
		super();
		this.brandRepository = brandRepository;
	}
	@Override
	public BrandDto saveBrand(BrandDto brandDto) {
		Brand brand = this.dtoTobBrand(brandDto);
		Brand savebrand = this.brandRepository.save(brand);
		return this.BrandToDto(savebrand);
	}

	@Override
	public List<BrandDto> getAllBrands() {
		List<Brand> brands = this.brandRepository.findAll();
		List<BrandDto> branddto = brands.stream().map(brand-> this.BrandToDto(brand)).collect(Collectors.toList());
		return branddto;
	}

	@Override
	public BrandDto getBrandById(int id) {
		Brand brand =this.brandRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Brand", "id", id));
		return this.BrandToDto(brand);
	}

	@Override
	public BrandDto UpdateBrand(BrandDto brand,int id) {
		Brand existingBrand = this.brandRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("brand", "id", id));
		existingBrand.setBrand_name(brand.getBrand_name());
		Brand updateAdmin = this.brandRepository.save(existingBrand);
		BrandDto branddto1 = this.BrandToDto(updateAdmin);
		
		return branddto1;
			
	}
	
	@Override
	public void deleteBrand(int id) {
		Brand brand =this.brandRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Brand", "id", id));	
		this.brandRepository.delete(brand);
			
	}
	
	
	
	public Brand dtoTobBrand(BrandDto brandDto) {
		Brand brand = this.modelmapper.map(brandDto, Brand.class);
		return brand;
	}
	
	
	public BrandDto BrandToDto(Brand brand) {
		BrandDto brandDto =this.modelmapper.map(brand, BrandDto.class);
		return brandDto;
	}

}
