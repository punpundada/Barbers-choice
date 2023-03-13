package com.spring.practice.service;

import java.util.List;

import com.spring.practice.responce.BrandDto;

public interface BrandService {
	BrandDto saveBrand (BrandDto brandDto);
	List<BrandDto> getAllBrands();
	BrandDto getBrandById(int id);
	BrandDto UpdateBrand(BrandDto brandDto,int id);
	void deleteBrand(int id);
	

}
