package com.spring.practice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class User_payment {
	

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int user_payment_id;
		private String provider;
		@ManyToOne
		@JoinColumn(name = "user_id")
		
		private User user;
		
		public int getUser_payment_id() {
			return user_payment_id;
		}
		public void setUser_payment_id(int user_payment_id) {
			this.user_payment_id = user_payment_id;
		}
		public String getProvider() {
			return provider;
		}
		public void setProvider(String provider) {
			this.provider = provider;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		
}
