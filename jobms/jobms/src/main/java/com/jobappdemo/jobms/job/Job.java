package com.jobappdemo.jobms.job;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String description;
	private String title;
	private int minSalary;
	private int maxSalary;
	private String location;
	private Long companyId;
	public Job() {
		
	}
	public Job(long id, String description, String title, int minSalary, int maxSalary, String location) {
		this.id = id;
		this.description = description;
		this.title = title;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.location = location;
	}
	
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
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
	@Override
	public String toString() {
		return "Job [id=" + id + ", description=" + description + ", title=" + title + ", minSalaray=" + minSalary
				+ ", maxSalary=" + maxSalary + ", location=" + location + "]";
	}
	
	
	
}
