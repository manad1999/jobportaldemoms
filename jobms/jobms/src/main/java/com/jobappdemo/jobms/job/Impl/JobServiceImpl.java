package com.jobappdemo.jobms.job.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jobappdemo.jobms.job.Job;
import com.jobappdemo.jobms.job.JobRepository;
import com.jobappdemo.jobms.job.JobService;
import com.jobappdemo.jobms.job.dto.JobDTO;
import com.jobappdemo.jobms.job.external.Company;
import com.jobappdemo.jobms.job.external.Review;
import com.jobappdemo.jobms.mapper.Mapper;

import jakarta.transaction.Transactional;

@Service
public class JobServiceImpl implements JobService{
	
	private JobRepository jobRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public JobServiceImpl(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	@Override
	public List<JobDTO> findAll() {
		List<Job> jobs = jobRepository.findAll();
		List<JobDTO> jobDTOs = new ArrayList<>();
		//RestTemplate restTemplate = new RestTemplate();
		for(Job job : jobs)
		{
			Long companyId = job.getCompanyId();
			Company company =  restTemplate.getForObject("http://COMPANY-SERVICE:8081/companies/"+companyId, Company.class);
			ResponseEntity<List<Review>> reviewsResponse =  restTemplate.exchange("http://REVIEW-SERVICE:8083/reviews?companyId=" + companyId, HttpMethod.GET, null, new ParameterizedTypeReference<List<Review>>() {});
			List<Review> reviews = reviewsResponse.getBody();
			JobDTO jobDTO = Mapper.JobMapper(job, company, reviews);
			jobDTOs.add(jobDTO);
		}
		
		return jobDTOs;
	}
	

	@Override
	public JobDTO getJob(Long id) {
		Optional<Job> job = jobRepository.findById(id);
		if(job.isPresent())
		{
			Long companyId = job.get().getCompanyId();
			Company company = restTemplate.getForObject("http://COMPANY-SERVICE:8081/companies/"+companyId, Company.class);
			ResponseEntity<List<Review>> reviewsResponse =  restTemplate.exchange("http://REVIEW-SERVICE:8083/reviews?companyId=" + companyId, HttpMethod.GET, null, new ParameterizedTypeReference<List<Review>>() {});
			List<Review> reviews = reviewsResponse.getBody();
			JobDTO jobDTO = Mapper.JobMapper(job.get(), company,reviews);
			return jobDTO;
		}
		else
			return null;
	}

	@Override
	@Transactional
	public Job postJob(Job job) {
		Job addedjob = jobRepository.save(job);
		return addedjob;
	}
	@Transactional
	@Override
	public Job updateJob(Long id, Job job) {
		
		Job toUpdateJob = jobRepository.findById(id).get();
		if(toUpdateJob ==  null)
			return null;
		else
		{
			toUpdateJob.setTitle(job.getTitle());
			toUpdateJob.setDescription(job.getDescription());
			toUpdateJob.setLocation(job.getLocation());
			toUpdateJob.setMinSalary(job.getMinSalary());
			toUpdateJob.setMaxSalary(job.getMaxSalary());
			jobRepository.save(toUpdateJob);
			
			return toUpdateJob;
		}
	}

	@Transactional
	@Override
	public boolean deleteJob(Long id) {
		// TODO Auto-generated method stub
		try
		{
			jobRepository.deleteById(id);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}		
	}

}
