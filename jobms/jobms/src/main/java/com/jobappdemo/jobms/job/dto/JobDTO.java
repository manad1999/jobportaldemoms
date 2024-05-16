package com.jobappdemo.jobms.job.dto;

import java.util.List;

import com.jobappdemo.jobms.job.Job;
import com.jobappdemo.jobms.job.external.Company;
import com.jobappdemo.jobms.job.external.Review;

public class JobDTO  {
	private long id;
	private String description;
	private String title;
	private int minSalary;
	private int maxSalary;
	private String location;
	private Company company;
	
	private List<Review> reviews;
	
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
	}
	public int getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(int maxSalary) {
		this.maxSalary = maxSalary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	

}
