package com.spring.practice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.spring.practice.entities.Admin;
import com.spring.practice.exception.ResourceNotFoundException;
import com.spring.practice.repository.AdminRepository;
import com.spring.practice.responce.AdminDto;
import com.spring.practice.service.AdminService;

@Service
@Component
public class AdminServiceImpl implements AdminService  {
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private ModelMapper modelmapper;
	

	public AdminServiceImpl(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}


	@Override
	public AdminDto saveAdmin(AdminDto adminDto) {
		
		Admin ad = this.dtoToAdmin(adminDto);
		Admin saveadmin = this.adminRepository.save(ad);
		return this.adminToDto(saveadmin);
	}


	@Override
	public List<AdminDto> getAllAdmins() {
		
		List<Admin> admins = this.adminRepository.findAll();
		List<AdminDto> admindto = admins.stream().map(admin-> this.adminToDto(admin)).collect(Collectors.toList());
		return admindto;
	}


	@Override
	public AdminDto getAdminById(int id) {
		
		Admin admin =this.adminRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Admin", "id", id));
		return this.adminToDto(admin);
	
		

	}


	@Override
	public AdminDto updateAdmin(AdminDto admindto, int id) {
		Admin admin = this.adminRepository.findById(id).orElseThrow();
		admin.setAdmin_last_login(admindto.getAdmin_last_login());
		admin.setAdmin_namefirst(admindto.getAdmin_namefirst());
		admin.setAdmin_namelast(admindto.getAdmin_namelast());
		
		Admin updateAdmin = this.adminRepository.save(admin);
		AdminDto admindto1 = this.adminToDto(updateAdmin);
		
		return admindto1;
		
		
	}

	@Override
	public void deleteAdmin(int id) {
		Admin admin=this.adminRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Admin", "id", id));	
		this.adminRepository.delete(admin);	
	}
	
	
	
	
	public Admin dtoToAdmin(AdminDto adminDto) {
		Admin admin = this.modelmapper.map(adminDto, Admin.class);
		return admin;
	}
	
	public AdminDto adminToDto(Admin admin) {
		AdminDto adminDto =this.modelmapper.map(admin, AdminDto.class);
		return adminDto;
	}
	 
}
