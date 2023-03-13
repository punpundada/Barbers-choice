package com.spring.practice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.spring.practice.entities.Manufacturer;
import com.spring.practice.exception.ResourceNotFoundException;
import com.spring.practice.repository.ManufacturerRepository;
import com.spring.practice.responce.ManfactureDto;
import com.spring.practice.service.ManufacturerService;
@Service
@Component
public class ManufacturerServiceImpl implements ManufacturerService {
	@Autowired
	private ManufacturerRepository manufacturerRepository;
	
	@Autowired
	private ModelMapper modelmapper;
	
		
	public @Autowired  ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
		super();
		this.manufacturerRepository = manufacturerRepository;
	}
	
	

	public  ManufacturerServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public ManfactureDto saveManufacturer(ManfactureDto manufacturerDto) {
		
		Manufacturer man = this.dtoToManufacturer(manufacturerDto);
		Manufacturer saveman = this.manufacturerRepository.save(man);
		return this.ManufacturerToDto(saveman);
	}

	@Override
	public List<ManfactureDto> getAllManufacturers() {
		List<Manufacturer> manfacturers = (List<Manufacturer>) this.manufacturerRepository.findAll();
		List<ManfactureDto> manfacturerdto = manfacturers.stream().map(manfa-> this.ManufacturerToDto(manfa)).collect(Collectors.toList());
		return manfacturerdto;
	}

	@Override
	public ManfactureDto getManufacturerById(int id) {

		Manufacturer manfac =this.manufacturerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Manufacturer", "id", id));
		return this.ManufacturerToDto(manfac);
	
	}

	@Override
	public ManfactureDto updateManufacturer(ManfactureDto manfactureDto, int id) {
		Manufacturer existingManufacturer = this.manufacturerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Manufacturer", "id", id));
		existingManufacturer.setManufacturer_address(manfactureDto.getManufacturer_address());

		existingManufacturer.setManufacturer_name(manfactureDto.getManufacturer_name());
		
		Manufacturer updateManfacturer = this.manufacturerRepository.save(existingManufacturer);
		ManfactureDto manfacdto1 = this.ManufacturerToDto(updateManfacturer);
		
		return manfacdto1;
		
		
		
		
	}

	@Override
	public void deleteManufacturer(int id) {
		Manufacturer manufacturer=this.manufacturerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Manufacturer", "id", id));	
		this.manufacturerRepository.delete(manufacturer);	
	}


	

	public Manufacturer dtoToManufacturer(ManfactureDto manfactureDto) {
		Manufacturer manfac = this.modelmapper.map(manfactureDto, Manufacturer.class);
		return manfac;
	}
	
	
	
	public ManfactureDto ManufacturerToDto(Manufacturer manfacture) {
		ManfactureDto manfDto =this.modelmapper.map(manfacture, ManfactureDto.class);
		return manfDto;
	}




	

}
