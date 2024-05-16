package com.jobdemo.reviewms.review;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ReviewImpl implements ReviewService {
	private ReviewRespository reviewRespository;


	public ReviewImpl(ReviewRespository reviewRespository) {
		this.reviewRespository = reviewRespository;
	}


	@Override
	public List<Review> getAllReviews(Long companyId) {
		List<Review> reviews = reviewRespository.findByCompanyId(companyId);
		return reviews;
	}


	@Override
	public boolean addReview(Long companyId, Review review) {
		// TODO Auto-generated method stub
		if(companyId != null && review != null)
		{
			
		
			review.setCompanyId(companyId);
			reviewRespository.save(review);
			return true;
		}
		return false;
	}


	@Override
	public Review getReview(Long reviewId) {
		// TODO Auto-generated method stub
		
		return reviewRespository.findById(reviewId).orElse(null);
		
	}


	@Override
	public boolean updateReview(Long reviewId, Review newreview) {
		Review review = reviewRespository.findById(reviewId).orElse(null);
		if(review != null)
		{
			review.setTitle(newreview.getTitle());
			review.setDescription(newreview.getDescription());
			review.setRating(newreview.getRating());
			review.setCompanyId(newreview.getCompanyId());
			return true;
		}
		
		return false;
	}


	@Override
	public boolean deleteReview(Long reviewId) {
		// TODO Auto-generated method stub
		Review deleteReview = reviewRespository.findById(reviewId).orElse(null);
		if(deleteReview != null){
			reviewRespository.delete(deleteReview);
			return true;
			
		}
		return false;
	}

}
