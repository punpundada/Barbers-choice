package com.spring.practice.service;

import java.util.List;

import com.spring.practice.responce.AdminDto;

public interface AdminService  {
	
	AdminDto saveAdmin(AdminDto adminDto);
	List<AdminDto> getAllAdmins();
	AdminDto getAdminById(int id);
	AdminDto updateAdmin(AdminDto adminDto, int id);
	void deleteAdmin(int id);
	
}
