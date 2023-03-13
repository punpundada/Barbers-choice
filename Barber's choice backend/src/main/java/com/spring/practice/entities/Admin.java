package com.spring.practice.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int admin_id;
	@NotBlank
	@Size(min = 4,max = 25 ,message = "Name should be between 4 to 25 letters")
	private String admin_namefirst;
	@NotBlank
	@Size(min = 4,max = 25,message = "Name should be between 4 to 25 letters")
	private String admin_namelast;
	private LocalDate admin_last_login;
	
	@ManyToOne
	private User user;
	
	@OneToOne
	@JoinColumn(name = "login_id")
	
	private Login login;

	
	
	public Admin(int admin_id, String admin_namefirst, String admin_namelast, LocalDate admin_last_login, User user,
			Login login) {
		super();
		this.admin_id = admin_id;
		this.admin_namefirst = admin_namefirst;
		this.admin_namelast = admin_namelast;
		this.admin_last_login = admin_last_login;
		this.user = user;
		this.login = login;
	}

	
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_namefirst() {
		return admin_namefirst;
	}

	public void setAdmin_namefirst(String admin_namefirst) {
		this.admin_namefirst = admin_namefirst;
	}

	public String getAdmin_namelast() {
		return admin_namelast;
	}

	public void setAdmin_namelast(String admin_namelast) {
		this.admin_namelast = admin_namelast;
	}



	public LocalDate getAdmin_last_login() {
		return admin_last_login;
	}

	public void setAdmin_last_login(LocalDate admin_last_login) {
		this.admin_last_login = admin_last_login;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	
}
