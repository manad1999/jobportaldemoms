package com.jobappdemo.jobms.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jobappdemo.jobms.job.external.Company;

@FeignClient(name = "COMPANY-SERVICE")
public interface CompanyClient {
	
	@GetMapping("/companies/{id}")
	Company getCompany(@PathVariable Long id);

}
