package com.spring.practice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.practice.entities.Brand;
import com.spring.practice.entities.User_address;
import com.spring.practice.exception.ResourceNotFoundException;
import com.spring.practice.repository.User_addressRepository;
import com.spring.practice.responce.BrandDto;
import com.spring.practice.responce.User_AddressDto;
import com.spring.practice.service.User_AddressService;

@Service
public class User_addressImpl implements User_AddressService{
	@Autowired
	private User_addressRepository user_Address_repo;
	
	@Autowired
	private ModelMapper modelmapper;

	public User_addressImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User_addressImpl(User_addressRepository user_Address_repo) {
		super();
		this.user_Address_repo = user_Address_repo;
	}

	@Override
	public User_AddressDto saveA_user_address(User_AddressDto user_address) {
		User_address  user_address1 = this.dtoTobUser_address(user_address);
		User_address saveUser_address = this.user_Address_repo.save(user_address1);
		return this.User_addressToDto(saveUser_address);
	}

	@Override
	public List<User_AddressDto> getAlluser_address() {
		List<User_address> user_address = (List<User_address>) this.user_Address_repo.findAll();
		List<User_AddressDto> user_AddressDto = user_address.stream().map(user_address1-> this.User_addressToDto(user_address1)).collect(Collectors.toList());
		return user_AddressDto;
	}

	@Override
	public User_AddressDto getuser_addressById(int id) {
		User_address user_address =this.user_Address_repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User_address", "id", id));
		return this.User_addressToDto(user_address);
	}

	@Override
	public User_AddressDto updateUser_address(User_AddressDto user_AddressDto, int id) {
		User_address existingUser = user_Address_repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("user_address", "id", id));
		existingUser.setAddress_line1(user_AddressDto.getAddress_line1());
		existingUser.setAddress_line2(user_AddressDto.getAddress_line2());
		existingUser.setCity(user_AddressDto.getCity());
		existingUser.setCountry(user_AddressDto.getCountry());
		existingUser.setPhone_nummber(user_AddressDto.getPhone_nummber());
		existingUser.setPostal_code(user_AddressDto.getPostal_code());
		existingUser.setTelephone(user_AddressDto.getTelephone());
		
		//User_address updateUser_address = this.user_Address_repo.save(existingUser);
		//User_AddressDto User_AddressDtodto1 = this.User_addressToDto(updateUser_address);
		
		return null;
	}

	@Override
	public void deleteUser_address(int id) {
		// TODO Auto-generated method stub
		User_address user_address =this.user_Address_repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User_address", "id", id));	
		this.user_Address_repo.delete(user_address);
		
	}
	
	public User_address dtoTobUser_address(User_AddressDto user_addressDto) {
		User_address user_address = this.modelmapper.map(user_addressDto, User_address.class);
		return user_address;
	}
	
	
	public User_AddressDto User_addressToDto(User_address user_address) {
		User_AddressDto user_addressDto =this.modelmapper.map(user_address, User_AddressDto.class);
		return user_addressDto;
	}

}
