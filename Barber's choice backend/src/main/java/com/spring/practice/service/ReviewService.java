package com.spring.practice.service;

import java.util.List;


import com.spring.practice.entities.Review;
import com.spring.practice.responce.ReviewDto;

public interface ReviewService {
	
	ReviewDto saveReview(ReviewDto reviewDto);
	List<ReviewDto> getAllReviews();
	ReviewDto getReviewById(int id);
	ReviewDto updateReview(ReviewDto reviewDto, int id);
	void deleteReview(int id);

}
