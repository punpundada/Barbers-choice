package com.spring.practice.responce;


import com.spring.practice.entities.Manufacturer;
import com.spring.practice.entities.User;

public class LoginDto {
	
	
	private int login_id;
	private String username;
	private String password;
	private String email;
	private long phone_number;
//    private AdminDto adminDto;

	
	
//	
//	public AdminDto getAdminDto() {
//		return adminDto;
//	}
//	public void setAdminDto(AdminDto adminDto) {
//		this.adminDto = adminDto;
//	}


	
	
	
//	public LoginDto(int login_id, String username, String password, String email, long phone_number,
//				AdminDto adminDto) {
//			super();
//			this.login_id = login_id;
//			this.username = username;
//			this.password = password;
//			this.email = email;
//			this.phone_number = phone_number;
//			
//		
//		}
	
	
	
	public int getLogin_id() {
		return login_id;
	}
	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}
	public LoginDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	

}
