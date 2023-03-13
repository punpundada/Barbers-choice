package com.spring.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.practice.responce.ApiResponce;
import com.spring.practice.responce.BrandDto;
import com.spring.practice.service.BrandService;



@RestController
@RequestMapping("/api/brand")
public class BrandController {
	@Autowired
	private BrandService brandService;

	public @Autowired BrandController(@RequestBody BrandService brandService) {
		super();
		this.brandService = brandService;
	}

	public BrandController() {
		super();
		// TODO Auto-generated constructor stub
	}
	@PostMapping
	public ResponseEntity<BrandDto> saveBrand(BrandDto brandDto) {
		BrandDto saveBrandDto= this.brandService.saveBrand(brandDto);
		return new ResponseEntity<>(saveBrandDto, HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<BrandDto>> getAllBrands() {
		return ResponseEntity.ok(this.brandService.getAllBrands());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<BrandDto> getBrandById(@PathVariable("id") int id) {
		return ResponseEntity.ok(this.brandService.getBrandById(id));
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<BrandDto> updateBrand(@PathVariable("id") int id,@RequestBody BrandDto brandDto) {
		BrandDto updateBrand = this.brandService.UpdateBrand(brandDto, id);
		return ResponseEntity.ok(updateBrand);
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponce> deleteBrand(@PathVariable("id") int id) {
		brandService.deleteBrand(id);
		
		this.brandService.deleteBrand(id);
		return new ResponseEntity<ApiResponce>(new ApiResponce("Brand Deleted successfully",true),HttpStatus.OK);
	}
	
}
