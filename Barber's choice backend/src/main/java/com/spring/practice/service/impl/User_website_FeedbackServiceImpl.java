package com.spring.practice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.practice.entities.Brand;
import com.spring.practice.entities.User_website_feedback;
import com.spring.practice.exception.ResourceNotFoundException;
import com.spring.practice.repository.User_website_feedbackRepository;
import com.spring.practice.responce.BrandDto;
import com.spring.practice.responce.User_website_feedbackDto;
import com.spring.practice.service.User_website_feedback_Service;

@Service
public class User_website_FeedbackServiceImpl implements User_website_feedback_Service {

	@Autowired
	private User_website_feedbackRepository user_Website_feedbackRepo;
	
	@Autowired
	private ModelMapper modelmapper;

	

	public User_website_FeedbackServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User_website_FeedbackServiceImpl(User_website_feedbackRepository user_Website_feedbackRepo) {
		super();
		this.user_Website_feedbackRepo = user_Website_feedbackRepo;
	}

	@Override
	public User_website_feedbackDto save_uwf(User_website_feedbackDto user_web_feed) {
		User_website_feedback user_website_feedback = this.dtoTobUser_Website_Feed(user_web_feed);
		User_website_feedback saveUser_website_feedback = this.user_Website_feedbackRepo.save(user_website_feedback);
		return this.User_Website_FeedToDto(saveUser_website_feedback);
	}

	@Override
	public List<User_website_feedbackDto> getAllFeedback() {
		List<User_website_feedback> user_website_feedback = (List<User_website_feedback>) this.user_Website_feedbackRepo.findAll();
		List<User_website_feedbackDto> user_website_feedbackDto1 = user_website_feedback.stream().map(user_website_feedback1-> this.User_Website_FeedToDto(user_website_feedback1)).collect(Collectors.toList());
		return user_website_feedbackDto1;
	}

	@Override
	public User_website_feedbackDto update_feedback(User_website_feedbackDto user_website_feedback, int id) {
		User_website_feedback user_webs_feed = user_Website_feedbackRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("user_Website_feedbackRepo", "id", id));
		user_webs_feed.setFeedback_text(user_website_feedback.getFeedback_text());
		User_website_feedback updatUser_website_feedback= this.user_Website_feedbackRepo.save(user_webs_feed);
		User_website_feedbackDto User_website_feedbackDto1 = this.User_Website_FeedToDto(updatUser_website_feedback);
		
		return User_website_feedbackDto1;
			
		
	
	}

	@Override
	public User_website_feedbackDto getUserById(int id) {
		User_website_feedback user_website_feedback =this.user_Website_feedbackRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User_website_feedback", "id", id));
		return this.User_Website_FeedToDto(user_website_feedback);
	}

	@Override
	public void deleteUserFeedbackById(int id) {
		// TODO Auto-generated method stub
		
		User_website_feedback user_Website_feedbackRepo =this.user_Website_feedbackRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User_website_feedback", "id", id));	
		this.user_Website_feedbackRepo.delete(user_Website_feedbackRepo);
	}
	
	public User_website_feedback  dtoTobUser_Website_Feed(User_website_feedbackDto user_website_feedbackDto) {
		User_website_feedback user_website_feedback = this.modelmapper.map(user_website_feedbackDto, User_website_feedback.class);
		return user_website_feedback;
	}
	
	
	public User_website_feedbackDto  User_Website_FeedToDto(User_website_feedback user_website_feedback) {
		User_website_feedbackDto user_website_feedbackDto =this.modelmapper.map(user_website_feedback, User_website_feedbackDto.class);
		return user_website_feedbackDto;
	}
	
	

}
