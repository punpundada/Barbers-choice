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
import com.spring.practice.responce.AdminDto;
import com.spring.practice.responce.ApiResponce;
import com.spring.practice.service.AdminService;

@RestController
@RequestMapping("/api/admin")

public class AdminController {
	
	@Autowired
	private AdminService adminService;

	@Autowired
	public  AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}

	public AdminController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	//creating admin rest api
	@PostMapping
	public ResponseEntity<AdminDto> saveAdmin(@Valid @RequestBody AdminDto adminDto){
		AdminDto saveadmindto = this.adminService.saveAdmin(adminDto);
		return new ResponseEntity<>(saveadmindto, HttpStatus.CREATED);
	}
	
	
	//creating get all admin rest api
	//http://localhost/api/admin
	
	@GetMapping
	public ResponseEntity<List<AdminDto>> getAllAdmins() {
		return ResponseEntity.ok(this.adminService.getAllAdmins());
	}
	
	//build get employee by id rest api
	//http://localhost/api/admin/6
	@GetMapping("{id}")
	public ResponseEntity<AdminDto> getAdminById(@PathVariable("id") int adminId) {
			return ResponseEntity.ok(this.adminService.getAdminById(adminId));
	}
	
	//update adimin rest api
	//http://localhost/api/admin/1
	@PutMapping("{id}")
	public ResponseEntity<AdminDto> updateAdmin(@Valid @PathVariable("id") int id, @RequestBody AdminDto adminDto) {
		
		AdminDto updateAdmin = this.adminService.updateAdmin(adminDto, id);
		return ResponseEntity.ok(updateAdmin);
	}
	
	
	//build delete controller rest api
	//http://localhost/api/admin/1
		@DeleteMapping("{id}")
		public ResponseEntity<ApiResponce> deleteAdmin(@PathVariable("id") int id) {
			adminService.deleteAdmin(id);
			
			this.adminService.deleteAdmin(id);
			return new ResponseEntity<ApiResponce>(new ApiResponce("Admin Deleted successfully",true),HttpStatus.OK);
		}
		
		
		
		
		
		
		
		
		
		
}
