package com.jobdemo.reviewms.review;

import java.util.List;

public interface ReviewService {
	
	public List<Review> getAllReviews(Long companyId);
	public boolean addReview(Long companyId, Review review);
	public Review getReview( Long reviewId);
	public boolean updateReview(Long reviewId, Review review);
	public boolean deleteReview(Long reviewId);

}
