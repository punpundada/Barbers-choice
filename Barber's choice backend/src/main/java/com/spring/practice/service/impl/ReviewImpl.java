package com.spring.practice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.practice.entities.Review;
import com.spring.practice.exception.ResourceNotFoundException;
import com.spring.practice.repository.ReviewRepository;
import com.spring.practice.responce.ReviewDto;
import com.spring.practice.service.ReviewService;

@Service
public class ReviewImpl implements ReviewService {
	@Autowired
	private ReviewRepository reviewRepo;
	@Autowired
	private ModelMapper modelmapper;

	@Override
	public ReviewDto saveReview(ReviewDto reviewDto) {
		Review review = this.dtoTobReview(reviewDto);
		Review savereview = this.reviewRepo.save(review);
		return this.ReviewToDto(savereview);
	}

	@Override
	public List<ReviewDto> getAllReviews() {
		List<Review> review = (List<Review>) this.reviewRepo.findAll();
		List<ReviewDto> reviewDto = review.stream().map(review1-> this.ReviewToDto(review1)).collect(Collectors.toList());
		return reviewDto;
	}

	@Override
	public ReviewDto getReviewById(int id) {
		Review review =this.reviewRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Review", "id", id));
		return this.ReviewToDto(review);
	}

	@Override
	public ReviewDto updateReview(ReviewDto reviewDto, int id) {
		Review existingReview= reviewRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("review", "id", id));
		existingReview.setReview(reviewDto.getReview());
		
		Review updateReview = this.reviewRepo.save(existingReview);
		ReviewDto DtoUpdateReview = this.ReviewToDto(updateReview);
		
		return DtoUpdateReview;
	}

	@Override
	public void deleteReview(int id) {
		Review review =this.reviewRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Review", "id", id));	
		this.reviewRepo.delete(review);
			
		
	}
	
	public Review dtoTobReview(ReviewDto reviewDto) {
		Review review = this.modelmapper.map(reviewDto, Review.class);
		return review;
	}
	
	
	public ReviewDto ReviewToDto(Review review) {
		ReviewDto reviewDto =this.modelmapper.map(review, ReviewDto.class);
		return reviewDto;
	}
	

}
