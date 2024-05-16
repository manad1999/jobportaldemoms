package com.jobappdemo.jobms.job;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long>{
	
//public List<Job> findAll();
//	
//	public Job getJob(Long id);
//	
//	public Job postJob(Job job);
//	
//	public Job updateJob(Job job);
//	
//	public int deleteJob(Long id);
}
