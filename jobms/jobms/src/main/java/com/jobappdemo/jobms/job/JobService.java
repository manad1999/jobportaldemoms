package com.jobappdemo.jobms.job;

import java.util.List;

import com.jobappdemo.jobms.job.dto.JobDTO;

public interface JobService {
	
	public List<JobDTO> findAll();
	
	public JobDTO getJob(Long id);
	
	public Job postJob(Job job);
	
	public Job updateJob(Long id, Job job);
	
	public boolean deleteJob(Long id);

}
