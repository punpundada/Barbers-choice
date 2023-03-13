package com.spring.practice.service;

import java.util.List;

import com.spring.practice.entities.Manufacturer;
import com.spring.practice.responce.ManfactureDto;

public interface ManufacturerService {
	ManfactureDto saveManufacturer(ManfactureDto manufacturerDto);
	List<ManfactureDto> getAllManufacturers();
	ManfactureDto getManufacturerById(int id);
	ManfactureDto updateManufacturer(ManfactureDto manufacturerDto,int id);
	void deleteManufacturer(int id);
}
