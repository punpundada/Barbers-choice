package com.spring.practice.service;

import java.util.List;

import com.spring.practice.entities.User_website_feedback;
import com.spring.practice.responce.User_website_feedbackDto;

public interface User_website_feedback_Service {
	
	User_website_feedbackDto  save_uwf(User_website_feedbackDto uwfDto);
	List<User_website_feedbackDto> getAllFeedback();
	User_website_feedbackDto update_feedback(User_website_feedbackDto uwfDto , int id);
	User_website_feedbackDto getUserById(int id);
	void deleteUserFeedbackById(int id);
	
	
	

}
