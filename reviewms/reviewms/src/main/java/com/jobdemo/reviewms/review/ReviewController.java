package com.jobdemo.reviewms.review;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
	
	private ReviewService reviewService;
	
	public ReviewController(ReviewService reviewService)
	{
		this.reviewService = reviewService;
	}
	
	@GetMapping
	public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId)
	{
		List<Review> reviews = reviewService.getAllReviews(companyId);
		return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> addReview(@RequestParam Long companyId, @RequestBody Review review)
	{
		boolean isAdded = reviewService.addReview(companyId, review);
		if(isAdded)
			return new ResponseEntity<String>("Review Added Successfully", HttpStatus.CREATED);
		else
			return new ResponseEntity<String>("Company Not found", HttpStatus.NOT_FOUND);
			
	}
	
	@GetMapping("{reviewId}")
	public ResponseEntity<Review> getReview(@PathVariable Long reviewId)
	{
		Review getReview = reviewService.getReview(reviewId);
		
		if(getReview != null)
		{
			return new ResponseEntity<Review>(getReview, HttpStatus.OK);
		}
		return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
	}
	@PutMapping("{reviewId}")
	public ResponseEntity<String> updateReview( @PathVariable Long reviewId, @RequestBody Review review)
	{
		boolean isUpdated = reviewService.updateReview(reviewId, review);
		if(isUpdated)
			return new ResponseEntity<String>("Review Updates Successfully", HttpStatus.OK);
		else
			return new ResponseEntity<String>("Review Not found", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("{reviewId}")
	public ResponseEntity<String> deleteReview( @PathVariable Long reviewId)
	{
		boolean isDeleted = reviewService.deleteReview( reviewId);
		
		if(isDeleted)
		{
			return new ResponseEntity<>("Reciew Deleted successfuk", HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
