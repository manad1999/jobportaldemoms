package com.jobappdemo.jobms.mapper;

import java.util.List;

import com.jobappdemo.jobms.job.Job;
import com.jobappdemo.jobms.job.dto.JobDTO;
import com.jobappdemo.jobms.job.external.Company;
import com.jobappdemo.jobms.job.external.Review;

public class Mapper {
	
	public static JobDTO JobMapper(Job job, Company company, List<Review> reviews)
	{
		JobDTO jobDTO = new JobDTO();
		jobDTO.setId(job.getId());
		jobDTO.setTitle(job.getTitle());
		jobDTO.setDescription(job.getDescription());
		jobDTO.setLocation(job.getLocation());
		jobDTO.setMinSalary(job.getMinSalary());
		jobDTO.setMaxSalary(job.getMaxSalary());
		jobDTO.setCompany(company);
		jobDTO.setReviews(reviews);
		
		return jobDTO;
		
		
	}

}
