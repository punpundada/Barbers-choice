package com.spring.practice.controller;

import java.util.List;

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

import com.spring.practice.entities.Review;
import com.spring.practice.responce.AdminDto;
import com.spring.practice.responce.ApiResponce;
import com.spring.practice.responce.ReviewDto;
import com.spring.practice.service.ReviewService;
@RestController
@RequestMapping("/api/review")
public class Review_Controller {
	@Autowired
	private ReviewService reviewService ;

	public Review_Controller(ReviewService reviewService) {
		super();
		this.reviewService = reviewService;
	}

	public Review_Controller() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping
	public ResponseEntity<ReviewDto> saveReview(ReviewDto reviewDto) {
		ReviewDto saveReviewDtoto = this.reviewService.saveReview(reviewDto);
		return new ResponseEntity<>(saveReviewDtoto, HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<ReviewDto>>getAllReviews() {
		return ResponseEntity.ok(this.reviewService.getAllReviews());
		
	}
	@GetMapping("{id}")
	public ResponseEntity<ReviewDto> getReviewById(@PathVariable("id") int id) {
		return ResponseEntity.ok(this.reviewService.getReviewById(id));
		
	}
	@PutMapping("{id}")
	public ResponseEntity<ReviewDto> updateReview(@PathVariable("id") int id,@RequestBody ReviewDto reviewDto) {
		ReviewDto updateReview = this.reviewService.updateReview(reviewDto, id);
		return ResponseEntity.ok(updateReview);
		
	}
	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponce> deleteReview(@PathVariable("id") int id) {
		reviewService.deleteReview(id);
		
		this.reviewService.deleteReview(id);
		return new ResponseEntity<ApiResponce>(new ApiResponce("Review Deleted successfully",true),HttpStatus.OK);
		
		}

}
