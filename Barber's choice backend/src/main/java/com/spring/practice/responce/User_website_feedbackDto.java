package com.spring.practice.responce;

import com.spring.practice.entities.User;

public class User_website_feedbackDto {
	
	private int feedback_id;
	private String feedback_text;
	private UserDto userdto;
	
	
	
	public User_website_feedbackDto(int feedback_id, String feedback_text) {
		super();
		this.feedback_id = feedback_id;
		this.feedback_text = feedback_text;
	}
	public User_website_feedbackDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getFeedback_id() {
		return feedback_id;
	}
	public UserDto getUserdto() {
		return userdto;
	}
	public void setUserdto(UserDto userdto) {
		this.userdto = userdto;
	}
	public void setFeedback_id(int feedback_id) {
		this.feedback_id = feedback_id;
	}
	public String getFeedback_text() {
		return feedback_text;
	}
	public void setFeedback_text(String feedback_text) {
		this.feedback_text = feedback_text;
	}
	
	

	
}
