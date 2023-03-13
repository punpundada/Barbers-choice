package com.spring.practice.controller;


import java.util.List;

import javax.validation.Valid;

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
import com.spring.practice.entities.Manufacturer;
import com.spring.practice.responce.AdminDto;
import com.spring.practice.responce.ApiResponce;
import com.spring.practice.responce.ManfactureDto;
import com.spring.practice.service.ManufacturerService;

@RestController
@RequestMapping("/api/manfacturer")

public class Manufacturer_Controller {
	@Autowired
	private ManufacturerService manufacturerService;

	public Manufacturer_Controller(ManufacturerService manufacturerService) {
		super();
		this.manufacturerService = manufacturerService;
	}

	public Manufacturer_Controller() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping
	public ResponseEntity<ManfactureDto> saveManufacturer(@RequestBody ManfactureDto manfacture){
	
		ManfactureDto manfactureDto = this.manufacturerService.saveManufacturer(manfacture);
			return new ResponseEntity<>(manfactureDto, HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public ResponseEntity<List<ManfactureDto>> getAllManufacturers() {
		return ResponseEntity.ok(this.manufacturerService.getAllManufacturers());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ManfactureDto> getManfacturerById(@PathVariable("id") int manfactureId) {
		return ResponseEntity.ok(this.manufacturerService.getManufacturerById(manfactureId));
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<ManfactureDto> updatemanfacturer(@Valid @PathVariable("id") int id, @RequestBody ManfactureDto manfactureDto) {
		ManfactureDto updateMan = this.manufacturerService.updateManufacturer(manfactureDto, id);
		return ResponseEntity.ok(updateMan);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponce> deletemanfacturer(@PathVariable("id") int id) {
		manufacturerService.deleteManufacturer(id);
		
		manufacturerService.deleteManufacturer(id);
		
		this.manufacturerService.deleteManufacturer(id);
		return new ResponseEntity<ApiResponce>(new ApiResponce("Manfacture Deleted successfully",true),HttpStatus.OK);
	}
	
	
}
